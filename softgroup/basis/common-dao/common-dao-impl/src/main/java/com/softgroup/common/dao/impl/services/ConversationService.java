package com.softgroup.common.dao.impl.services;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.impl.repositories.ConversationRepository;
import org.springframework.stereotype.Service;

/**
 * @author AlexKazmirchuk
 * @since 13.03.17.
 */

@Service
public class ConversationService extends
        CommonService<ConversationEntity,ConversationRepository> {
}
