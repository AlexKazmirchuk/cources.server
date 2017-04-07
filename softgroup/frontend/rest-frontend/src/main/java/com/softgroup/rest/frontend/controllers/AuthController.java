package com.softgroup.rest.frontend.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.exceptions.MapperException;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.protocol.factories.ResponseFactory;
import com.softgroup.common.router.impl.FirstRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AlexKazmirchuk
 * @since 25.03.17.
 */
@RestController
public class AuthController {

    @Autowired
    private DataMapper mapper;

    @Autowired
    private FirstRouter firstRouter;

    @RequestMapping(path = "api/public", method = RequestMethod.POST)
    private String handlePublicRequest(@RequestBody String jsonRequestData){
        Request<?> msg;
        try {
            msg = mapper.mapData(jsonRequestData, new TypeReference<Request<?>>() {});
        } catch (MapperException e){
            return mapper.objectToString(ResponseFactory.createResponse(null,new ResponseStatus(400,"Bad request")));
        }
        return mapper.objectToString(firstRouter.handle(msg));
    }

    @RequestMapping
    private String commonRequestHandle(){
        return "Welcome to our Messenger!";
    }

}
