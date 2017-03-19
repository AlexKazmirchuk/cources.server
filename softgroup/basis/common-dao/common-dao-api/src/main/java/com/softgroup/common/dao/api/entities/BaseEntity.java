package com.softgroup.common.dao.api.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 09.03.17.
 */

@MappedSuperclass
public abstract class BaseEntity implements Serializable{

    private static final long serialVersionUID = 3003581931598837562L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
