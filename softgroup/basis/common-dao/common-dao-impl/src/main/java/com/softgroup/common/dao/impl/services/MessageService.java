package com.softgroup.common.dao.impl.services;

import com.softgroup.common.dao.api.entities.MessageEntity;
import com.softgroup.common.dao.impl.repositories.MessageRepository;
import org.springframework.stereotype.Service;

/**
 * @author AlexKazmirchuk
 * @since 13.03.17.
 */

@Service
public class MessageService extends
        CommonService<MessageEntity,MessageRepository> {
}
