package com.softgroup.common.dao.api.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */

@Entity
@Table(name = "contacts")
public class ContactEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3180111570947462349L;

    //todo add other fields later

    public ContactEntity() {
    }

}
