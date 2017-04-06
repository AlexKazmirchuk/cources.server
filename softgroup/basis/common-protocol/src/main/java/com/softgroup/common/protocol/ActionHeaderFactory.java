package com.softgroup.common.protocol;

import java.util.UUID;

/**
 * @author AlexKazmirchuk
 * @since 30.03.17.
 */
public class ActionHeaderFactory {
    public static ActionHeader createHeader(ActionHeader requestHeader){
        return ActionHeader.newBuilder()
                .setType(requestHeader.getType())
                .setCommand(requestHeader.getCommand())
                .setVersion(requestHeader.getVersion())
                .setOriginUuid(requestHeader.getUuid())
                .setUuid(ActionHeader.SERVER_UUID)
                .build();
    }
}
