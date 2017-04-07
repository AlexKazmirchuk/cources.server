package com.softgroup.common.validation.impl;

import com.softgroup.common.exceptions.InvalidRequestException;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.validation.api.RequestValidationService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.util.Arrays.asList;

/**
 * @author AlexKazmirchuk
 * @since 06.04.17.
 */

@Component
public class RequestValidationServiceImpl implements RequestValidationService {

    private List<String> types;

    private Map<String,List<String>> handlerMap;

    @PostConstruct
    private void init(){
        types = asList("authorization","profile","messenger");

        List<String> authCommands = asList("register","sms_confirm","login");
        List<String> profileCommands = asList("contacts_sync","get_contact_profiles"
                                    ,"get_last_time_online","get_my_profile"
                                    ,"get_other_profiles","get_profile_settings"
                                    ,"set_my_profile","set_profile_settings");
        List<String> messengerCommands = asList("create_conversation","delete_conversation"
                                        ,"get_conversation_details","get_conversations_by_ids"
                                        ,"get_conversations_details","get_conversation_settings"
                                        ,"get_conversations","get_conversations_settings"
                                        ,"get_messages","is_typing_in_chat"
                                        ,"messages_read_confirmation","send_message"
                                        ,"update_conversation_settings");

        handlerMap.put("authorization", authCommands);
        handlerMap.put("profile", profileCommands);
        handlerMap.put("messenger", messengerCommands);
    }

    @Override
    public void validateRequest(Request<?> request) throws InvalidRequestException {
        // todo implement later
        validateType(request.getHeader().getType());
        validateCommand(request.getHeader().getType(),request.getHeader().getCommand());
        validateUuid(request.getHeader().getUuid());

    }

    private void validateType(String type) throws InvalidRequestException{
        if (!types.contains(type)){
            throw new InvalidRequestException("Invalid type");
        }
    }

    private void validateCommand(String type, String command) throws InvalidRequestException{
        if (!handlerMap.get(type).contains(command)){
            throw new InvalidRequestException("Invalid command");
        }
    }

    private void validateUuid(String uuid) throws InvalidRequestException{
        try {
            UUID result = UUID.fromString(uuid);
        } catch (IllegalArgumentException e){
            throw new InvalidRequestException("Invalid uuid");
        }
    }

}
