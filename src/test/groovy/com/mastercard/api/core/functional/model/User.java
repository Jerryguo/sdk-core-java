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
import com.mastercard.api.core.model.*;
import com.mastercard.api.core.security.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;



public class User extends BaseObject  {

    public User() {
    }

    public User(BaseObject o) {
        putAll(o);
    }

    public User(Map m) {
        putAll(m);
    }


    @Override
    protected String getResourcePath(Action action) throws IllegalArgumentException {
        if (action == null) {
            throw new IllegalArgumentException("Action cannot be null");
        }
        if (action == Action.list) {
           return "/mock_crud_server/users";
        }
        if (action == Action.create) {
            return "/mock_crud_server/users";
        }
        if (action == Action.read) {
            return "/mock_crud_server/users/{id}";
        }
        if (action == Action.update) {
            return "/mock_crud_server/users/{id}";
        }
        if (action == Action.delete) {
            return "/mock_crud_server/users/{id}";
        }
        throw new IllegalArgumentException("Invalid action supplied: " + action);
    }


    @Override
    protected List<String> getHeaderParams(Action action) throws IllegalArgumentException {
        if (action == null) {
            throw new IllegalArgumentException("Action cannot be null");
        }
        if (action == Action.list) {
           return Arrays.asList();
        }
        if (action == Action.create) {
            return Arrays.asList();
        }
        if (action == Action.read) {
            return Arrays.asList();
        }
        if (action == Action.update) {
            return Arrays.asList();
        }
        if (action == Action.delete) {
            return Arrays.asList();
        }
        throw new IllegalArgumentException("Invalid action supplied: " + action);
    }

    @Override protected String getApiVersion() {
        return "0.0.1";
    }

    
    
    
    
    /**
     * Retrieve <code>User</code> objects using the static properties <code>ApiController.PUBLIC_KEY</code> and
     * <code>ApiController.PRIVATE_KEY</code> as the default public and private API keys respectively and the default
     * criteria (max 20, offset 0, default sorting and no filtering).
     *
     * @return      a ResourceList<User> object which holds the list of User objects and the total
     *              number of User objects available.
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     *
     * @see ResourceList
     */
    public static ResourceList<User> list()
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        return BaseObject.listObjects(null, new User(), null);
    }

    /**
     * Retrieve <code>User</code> objects using the default criteria (max 20, offset 0, default sorting and no filtering).
     *
     * @param       auth Authentication object representing overrides for <code>ApiController.PRIVATE_KEY</code> and <code>ApiController.PUBLIC_KEY</code> and/or passing an access token in for operations using OAuth.
     *
     * @return      a ResourceList<User> object which holds the list of User objects and the total
     *              number of User objects available.
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     *
     * @see ResourceList
     */
    public static ResourceList<User> list(Authentication auth)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        return BaseObject.listObjects(auth, new User(), null);
    }

    /**
     * Retrieve <code>User</code> objects using the specified criteria and using the static properties
     * <code>ApiController.PUBLIC_KEY</code> and <code>ApiController.PRIVATE_KEY</code> as the default public and private
     * API keys respectively.
     *
     * @param       criteria a map of parameters; valid keys and types are:<dl style="padding-left:10px;"><#list method.visibleFlattenedInputs as input>
     *              <dt><code>${input.type} ${input.fullName}</code></dt>    <dd>${input.message} <#if input.required == true><strong>required </strong></#if><#if input.fullName == 'sorting'>The value maps properties to the sort direction (either <code>asc</code> for ascending or <code>desc</code> for descending).  Sortable properties are: <#list sortableProperties as input><code>${input}</code> </#list>.</#if></dd></#list></dl>
     *
     * @return      a ResourceList<User> object which holds the list of User objects and the total
     *              number of User objects available.
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     *
     * @see ResourceList
     */
    public static ResourceList<User> list(Map criteria)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        return BaseObject.listObjects(null, new User(), criteria);
    }

    /**
     * Retrieve <code>User</code> objects using the specified criteria.
     *
     * @param       auth Authentication object representing overrides for <code>ApiController.PRIVATE_KEY</code> and <code>ApiController.PUBLIC_KEY</code> and/or passing an access token in for operations using OAuth.
     * @param       criteria a map of parameters; valid keys and types are: <dl style="padding-left:10px;"><#list method.visibleFlattenedInputs as input>
     *              <dt><code>${input.type} ${input.fullName}</code></dt> <dd>${input.message} <#if input.required == true><strong>required </strong></#if><#if input.fullName == 'sorting'>The value maps properties to the sort direction (either <code>asc</code> for ascending or <code>desc</code> for descending). Sortable properties are: <#list sortableProperties as input> <code>${input}</code> </#list>.</#if></dd></#list></dl>
     *
     * @return      a ResourceList<User> object which holds the list of User objects and the total
     *              number of User objects available.
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     *
     * @see ResourceList
     */
    public static ResourceList<User> list(Authentication auth, Map criteria)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        return BaseObject.listObjects(auth, new User(), criteria);
    }


    
    
    // body:(query:, param:, header:, cookie:, body:true)
    
    /**
     * Creates an <code>User</code> object using the static properties <code>ApiController.PUBLIC_KEY</code> and
     * <code>ApiController.PRIVATE_KEY</code> as the default public and private API keys respectively.
     *
     * @param       map  a map of parameters, valid keys and types:<dl style="padding-left:10px;"><#list method.visibleFlattenedInputs as input>
     *              <dt><code>${input.type} ${input.fullName}</code></dt>    <dd>${input.message} <#if input.required == true><strong>required </strong></#if></dd></#list></dl>
     *
     * @return      a User object.
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public static User create(RequestMap map)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        return create(null, map);
    }

    /**
     * Creates an <code>User</code> object
     *
     * @param       auth Authentication object representing overrides for <code>ApiController.PRIVATE_KEY</code> and <code>ApiController.PUBLIC_KEY</code> and/or passing an access token in for operations using OAuth.
     * @param       privateKey Private API key. If null, the value of static <code>ApiController.PRIVATE_KEY</code> will be used
     * @param       map  a map of parameters, valid keys and types: <dl style="padding-left:10px;"><#list method.visibleFlattenedInputs as input>
     *              <dt><code>${input.type} ${input.fullName}</code></dt> <dd>${input.message} <#if input.required == true><strong>required </strong></#if></dd></#list></dl>
     *
     * @return      a User object.
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public static User create(Authentication auth, RequestMap map)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        return new User(BaseObject.createObject(auth, new User(map)));
    }

    
    
    
    
    // id:(query:, param:true, header:, cookie:, body:)
    
    
    
    
    
    /**
     * Retrieve a <code>User</code> object using the static properties <code>ApiController.PUBLIC_KEY</code> and
     * <code>ApiController.PRIVATE_KEY</code> as the default public and private API keys respectively.
     *
     * @param       id  the id of the User object to retrieve
     *
     * @return      a User object
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public static User read(String id)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        return read(null, id, null);
    }

    /**
     * Retrieve a <code>User</code> object using the static properties <code>ApiController.PUBLIC_KEY</code> and
     * <code>ApiController.PRIVATE_KEY</code> as the default public and private API keys respectively.
     *
     * @param       id  the id of the User object to retrieve
     * @param       query a map of additional query parameters
     *
     * @return      a User object
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public static User read(String id, Map query)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        return read(null, id, query);
    }

    /**
     * Retrieve a <code>User</code> object.
     *
     * @param       auth Authentication object representing overrides for <code>ApiController.PRIVATE_KEY</code> and <code>ApiController.PUBLIC_KEY</code> and/or passing an access token in for operations using OAuth.
     * @param       id  the id of the <code>User</code> object to retrieve
     *
     * @return      a User object
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public static User read(Authentication auth, String id)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        return read(auth, id, null);
    }

    /**
     * Retrieve a <code>User</code> object.
     *
     * @param       auth Authentication object representing overrides for <code>ApiController.PRIVATE_KEY</code> and <code>ApiController.PUBLIC_KEY</code> and/or passing an access token in for operations using OAuth.
     * @param       id  the id of the <code>User</code> object to retrieve
     * @param       query a map of additional query parameters
     *
     * @return      a User object
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public static User read(Authentication auth, String id, Map query)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        User val = new User();
        if (id != null) val.put("id", id);
        if (query != null)  val.putAll(query);
        return new User(BaseObject.readObject(auth, val));
    }

    // id:(query:, param:true, header:, cookie:, body:)// body:(query:, param:, header:, cookie:, body:true)
    
    
    /**
     * Updates an <code>User</code> object.
     *
     * The properties that can be updated:
     * <ul><#list method.visibleFlattenedInputs as input>
     * <#if input.fullName != "id"><li>${input.name} <#if input.required == true><strong>(required)</strong></#if></li></#if>
     * </#list></ul>
     *
     * @return      a User object.
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public User update()
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        BaseObject object = this.updateObject(this);
        this.putAll(object);
        return this;
    }

    /**
     * Updates an <code>User</code> object.
     *
     * The properties that can be updated:
     * <ul><#list method.visibleFlattenedInputs as input>
     * <#if input.fullName != "id"><li>${input.name} <#if input.required == true><strong>(required)</strong></#if></li></#if>
     * </#list></ul>
     *
     * @param       auth Authentication object representing overrides for <code>ApiController.PRIVATE_KEY</code> and <code>ApiController.PUBLIC_KEY</code> and/or passing an access token in for operations using OAuth.
     *
     * @return      a User object.
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public User update(Authentication auth)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        BaseObject object = this.updateObject(auth, this);
        this.putAll(object);
        return this;
    }

    
    
    
    // id:(query:, param:true, header:, cookie:, body:)
    
    
    
    
    /**
     * Deletes an <code>User</code> object.
     *
     * @return      a User object.
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public User delete()
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        BaseObject object = this.deleteObject(this);
        this.putAll(object);
        return this;
    }

    /**
     * Deletes an <code>User</code> object.
     *
     * @return      a User object.
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public User delete(Authentication auth)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        BaseObject object = this.deleteObject(auth, this);
        this.clear();
        this.putAll(object);
        return this;
    }

    /**
     * Deletes an <code>User</code> object using the static properties <code>ApiController.PUBLIC_KEY</code> and
     * <code>ApiController.PRIVATE_KEY</code> as the default public and private API keys respectively.
     *
     * @param       id  the id of the object to delete
     *
     * @return      a User object.
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public static User delete(String id)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        return delete(null, id);
    }

    /**
     * Deletes an <code>User</code> object
     * @param       auth Authentication object representing overrides for <code>ApiController.PRIVATE_KEY</code> and <code>ApiController.PUBLIC_KEY</code> and/or passing an access token in for operations using OAuth.
     * @param       id  the id of the object to delete
     *
     * @return      a User object.
     *
     * @throws      ApiCommunicationException
     * @throws      AuthenticationException
     * @throws      InvalidRequestException
     * @throws      MessageSignerException
     * @throws      NotAllowedException
     * @throws      ObjectNotFoundException
     * @throws      SystemException
     */
    public static User delete(Authentication auth, String id)
        throws ApiCommunicationException, AuthenticationException, InvalidRequestException,
        MessageSignerException, NotAllowedException, ObjectNotFoundException, SystemException {

        User object = new User(new RequestMap("id", id));
        return object.delete(auth);
    }
    
    
}

