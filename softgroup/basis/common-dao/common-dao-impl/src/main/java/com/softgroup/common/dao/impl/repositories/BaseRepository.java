package com.softgroup.common.dao.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @author AlexKazmirchuk
 * @since 09.03.17.
 */

@NoRepositoryBean
public interface BaseRepository<T extends Serializable> extends JpaRepository<T,String> {
}
