package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.MessageEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */

public interface MessageRepository extends PagingAndSortingRepository<MessageEntity,String> {
}
