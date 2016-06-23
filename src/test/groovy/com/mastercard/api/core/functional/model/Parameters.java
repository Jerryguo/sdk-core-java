/*
 * Copyright 2016 MasterCard International.
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

package com.mastercard.api.core.functional.model;

import com.mastercard.api.core.exception.*;
import com.mastercard.api.core.model.Action;
import com.mastercard.api.core.model.BaseObject;
import com.mastercard.api.core.security.Authentication;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



public class Parameters extends BaseObject  {

    public Parameters() {
    }

    public Parameters(BaseObject o) {
        putAll(o);
    }

    public Parameters(Map m) {
        putAll(m);
    }


    @Override
    protected String getResourcePath(Action action) throws IllegalArgumentException {
        if (action == null) {
            throw new IllegalArgumentException("Action cannot be null");
        }
        if (action == Action.query) {
            return "/sectorinsights/v1/sectins.svc/parameters";
        }
        throw new IllegalArgumentException("Invalid action supplied: " + action);
    }


    @Override
    protected List<String> getHeaderParams(Action action) throws IllegalArgumentException {
        if (action == null) {
            throw new IllegalArgumentException("Action cannot be null");
        }
        if (action == Action.query) {
            return Arrays.asList();
        }
        
        throw new IllegalArgumentException("Invalid action supplied: " + action);
    }


    @Override protected String getApiVersion() {
        return "0.0.1";
    }
    
    
    
    
    
        /**
     * Query / Retrieve a <code>Parameters</code> object.
     *
     * @param       query a map of additional query parameters
     *
     * @return      a Parameters object
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public static Parameters query(Map query)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        return query(null, query);
    }

    /**
     * Query / Retrieve a <code>Parameters</code> object.
     *
     * @param       auth Authentication object representing overrides for <code>ApiController.PRIVATE_KEY</code> and <code>ApiController.PUBLIC_KEY</code> and/or passing an access token in for operations using OAuth.
     * @param       query a map of additional query parameters
     *
     * @return      a Parameters object
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public static Parameters query(Authentication auth, Map query)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        Parameters val = new Parameters();
        if (query != null)  val.putAll(query);
        return new Parameters(BaseObject.queryObject(auth, val));
    }

    
}

