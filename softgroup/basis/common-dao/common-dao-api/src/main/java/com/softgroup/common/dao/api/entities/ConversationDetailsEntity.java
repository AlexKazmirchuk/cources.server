package com.softgroup.common.dao.api.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */

@Entity
@Table(name = "conversation_details")
public class ConversationDetailsEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1998848853529676807L;

    //todo add other fields later

    public ConversationDetailsEntity() {
    }

}
