package com.softgroup.common.protocol;

import java.io.Serializable;

public class ActionHeader implements Serializable {
	private static final long serialVersionUID = -6161658016500127613L;

	public static final String SERVER_UUID = "6fbc6af7-f6e7-473f-9f46-508906f52bf7";

	private String uuid;
    private String originUuid;
    private String command;
    private String type;
    private String version;

    public ActionHeader(String uuid, String originUuid, String command, String type, String version) {
        this.uuid = uuid;
        this.originUuid = originUuid;
        this.command = command;
        this.type = type;
        this.version = version;
    }

    public ActionHeader() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOriginUuid() {
        return originUuid;
    }

    public void setOriginUuid(String originUuid) {
        this.originUuid = originUuid;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static Builder newBuilder(){
        return new ActionHeader().new Builder();
    }

    public class Builder {

        private Builder(){

        }

        public Builder setUuid(String uuid) {
            ActionHeader.this.uuid = uuid;
            return this;
        }

        public Builder setOriginUuid(String originUuid) {
            ActionHeader.this.originUuid = originUuid;
            return this;
        }

        public Builder setCommand(String command) {
            ActionHeader.this.command = command;
            return this;
        }

        public Builder setType(String type) {
            ActionHeader.this.type = type;
            return this;
        }

        public Builder setVersion(String version) {
            ActionHeader.this.version = version;
            return this;
        }

        public ActionHeader build(){
            return ActionHeader.this;
        }
    }

}
