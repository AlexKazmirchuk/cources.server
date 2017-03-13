package com.softgroup.common.dao.api.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */

@Entity
@Table(name = "conversation_settings")
public class ConversationSettingsEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 7214265511617637837L;

    //todo add other fields later

    public ConversationSettingsEntity() {
    }

}
