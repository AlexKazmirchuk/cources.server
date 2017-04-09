package com.softgroup.rest.frontend.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.exceptions.MapperException;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.ResponseStatusType;
import com.softgroup.common.protocol.factories.MessageFactory;
import com.softgroup.common.router.impl.FirstRouter;
import com.softgroup.rest.frontend.configuration.security.TokenAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AlexKazmirchuk
 * @since 14.03.17.
 */

@RestController
@RequestMapping(method = RequestMethod.POST)
public class MainController {

    @Autowired
    private DataMapper mapper;

    @Autowired
    private FirstRouter firstRouter;

    @RequestMapping(path = "/api/private")
    private String handlePrivateRequest(@RequestBody String jsonRequestData){
        Request<?> msg;

        try {
            msg = mapper.mapData(jsonRequestData, new TypeReference<Request<?>>() {});
        } catch (MapperException e){
            return mapper.objectToString(MessageFactory.createResponse(null, ResponseStatusType.BAD_REQUEST));
        }

        TokenAuthentication authentication = ((TokenAuthentication)(SecurityContextHolder.getContext().getAuthentication()));
        msg.setProfileID(authentication.getProfileID());
        msg.setDeviceID(authentication.getDeviceID());

        return mapper.objectToString(firstRouter.handle(msg));
    }

}
