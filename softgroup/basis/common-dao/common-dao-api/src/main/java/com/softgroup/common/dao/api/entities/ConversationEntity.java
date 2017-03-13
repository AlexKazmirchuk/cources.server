package com.softgroup.common.dao.api.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */
@Entity
@Table(name = "conversations")
public class ConversationEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -8700529675793334330L;

    //todo add other fields later

    public ConversationEntity() {
    }

}
