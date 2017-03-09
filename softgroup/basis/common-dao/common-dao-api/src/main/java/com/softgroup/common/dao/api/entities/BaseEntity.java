package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 09.03.17.
 */

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements Serializable{

    private static final long serialVersionUID = 3003581931598837562L;

    @Id
    @Column(name = "id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
