package com.softgroup.common.dao.api.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */

@Entity
@Table(name = "profile_statuses")
public class ProfileStatusEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5692872742644522060L;

    //todo add other fields later

    public ProfileStatusEntity() {
    }

}
