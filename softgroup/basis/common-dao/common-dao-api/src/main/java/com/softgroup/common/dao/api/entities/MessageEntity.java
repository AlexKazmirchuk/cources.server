package com.softgroup.common.dao.api.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */
@Entity
@Table(name = "messages")
public class MessageEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6779438608811972046L;

    //todo add other fields later

    public MessageEntity() {
    }

}
