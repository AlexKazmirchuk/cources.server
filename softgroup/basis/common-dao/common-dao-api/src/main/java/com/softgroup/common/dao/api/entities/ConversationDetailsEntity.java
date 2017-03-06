package com.softgroup.common.dao.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */

@Entity
@Table(name = "conversation_details")
public class ConversationDetailsEntity implements Serializable {

    private static final long serialVersionUID = -1998848853529676807L;

    @Id
    @Column(name = "id")
    private String id;

    //todo add other fields later

    public ConversationDetailsEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
