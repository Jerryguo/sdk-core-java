/*
 * Copyright 2015 MasterCard International.
 *
 * Redistribution and use in source and binary forms, with or without modification, are 
 * permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of 
 * conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of 
 * conditions and the following disclaimer in the documentation and/or other materials 
 * provided with the distribution.
 * Neither the name of the MasterCard International Incorporated nor the names of its 
 * contributors may be used to endorse or promote products derived from this software 
 * without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES 
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING 
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF 
 * SUCH DAMAGE.
 *
 */

package com.mastercard.api.core.exception;

import com.mastercard.api.core.model.map.CaseInsensitiveSmartMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Base class for all API exceptions.
 */
public class ApiException extends Exception {



    private String source;
    private String reasonCode;
    private String description;
    private Integer httpStatus;
    private CaseInsensitiveSmartMap rawErrorData;

    private List<Map<? extends String, ? extends Object>> errors = new ArrayList<Map<? extends String, ? extends Object>>();

    /**
     * Constructs an <code>ApiException</code> with no detail description.
     */
    public ApiException() {
        super();
    }

    /**
     * Constructs an <code>ApiException</code> with the specified detail description.
     *
     * @param s the detail description.
     */
    public ApiException(String s) {
        super(s);
    }

    /**
     * Constructs an <code>ApiException</code> with the specified detail description
     * and cause.
     *
     * @param s     the detail description.
     * @param cause the detail description.
     */
    public ApiException(String s, Throwable cause) {
        super(s, cause);
    }

    /**
     * Constructs an <code>ApiCommunicationException</code> with the specified cause.
     *
     * @param cause the detail description.
     */
    public ApiException(Throwable cause) {
        super(cause);
    }



    /**
     * Constructs an <code>ApiException</code> with the specified details httpStatus
     * and error data.
     *
     * @param httpStatus    the HTTP httpStatus code
     * @param errorData a map representing the error details returned by the API.  The map is
     *                  expected to contain <code>String</code> value for the key  <code>"reference"</code> and
     *                  a map containing the detailed error data for the key <code>"key"</code>.  This map in turn
     *                  is expected to contain <code>String</code> values for the keys
     *                  <code>"code"</code> and <code>"description"</code>.
     */
    public ApiException(int httpStatus, Map<? extends String, ? extends Object> errorData) {
        super();

        this.httpStatus = httpStatus;


        Map tmpMap = (Map<String,Object>) errorData;

        // Use SmartMap for easy traversing
        this.rawErrorData = new CaseInsensitiveSmartMap(tmpMap);


        if (rawErrorData.containsKey("Errors")) {
            Object o = rawErrorData.get("Errors");

            if (o instanceof Map && ((Map) o).containsKey("Error")) {
                o = ((Map) o).get("Error");
            }

            if (o instanceof List) {
                errors= (List<Map<? extends String, ? extends Object>>) o;
            } else if (o instanceof Map){
                errors.add((Map<? extends String, ? extends Object>) o);
            }

            // Use the first error
            if (errors.size() > 0) {
                Map<? extends String, ? extends Object> error = errors.get(0);
                if (error.containsKey("Source")) {
                    source = error.get("Source").toString();
                }
                if (error.containsKey("ReasonCode")) {
                    reasonCode = error.get("ReasonCode").toString();
                }
                if (error.containsKey("Description")) {
                    description = error.get("Description").toString();
                }
            }
        }



    }

    /**
     * Returns the error code for this exception.
     *
     * @return a string representing the API error code (which may be <code>null</code>).
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * Returns the HTTP httpStatus code for this exception.
     *
     * @return an integer representing the HTTP httpStatus code for this API error (or 0 if there is no httpStatus)
     */
    public Integer getHttpStatus() {
        return httpStatus;
    }

    /**
     * Returns the Error source
     * @return
     */
    public String getSource() {
        return source;
    }

    public List<Map<? extends String, ? extends Object>> getErrors() {
        return errors;
    }

    public CaseInsensitiveSmartMap getRawErrorData() {
        return rawErrorData;
    }

    /**
     * Returns the string detail description for this exception.
     *
     * @return a string representing the API error code or the description detail used to construct
     * the exception (which may be <code>null</code>).
     */
    @Override
    public String getMessage() {
        if (description == null) {
            return super.getMessage();
        }

        return description;
    }

    /**
     * Returns a string describing the exception.
     *
     * @return a string describing the exception.
     */
    public String describe() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName())
                .append(": \"")
                .append(getMessage())
                .append("\" (httpStatus: ")
                .append(getHttpStatus())
                .append(", reasonCode: ")
                .append(getReasonCode())
                .append(", source: ")
                .append(getSource())
                .append(")").toString();
    }
}
