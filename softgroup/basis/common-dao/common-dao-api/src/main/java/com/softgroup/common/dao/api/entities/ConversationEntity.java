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
@Table(name = "conversations")
public class ConversationEntity implements Serializable {

    private static final long serialVersionUID = -8700529675793334330L;

    @Id
    @Column(name = "id")
    private String id;

    //todo add other fields later

    public ConversationEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
