package com.softgroup.rest.frontend.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.impl.FirstRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    @RequestMapping
    private String handleRequest(@RequestBody String jsonRequestData){
        Request<?> msg = mapper.mapData(jsonRequestData, new TypeReference<Request<?>>() {});
        return mapper.objectToString(firstRouter.handle(msg));
    }

}
