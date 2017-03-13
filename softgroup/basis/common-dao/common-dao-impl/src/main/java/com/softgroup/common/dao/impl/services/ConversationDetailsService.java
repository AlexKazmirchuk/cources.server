package com.softgroup.common.dao.impl.services;

import com.softgroup.common.dao.api.entities.ConversationDetailsEntity;
import com.softgroup.common.dao.impl.repositories.ConversationDetailsRepository;
import org.springframework.stereotype.Service;

/**
 * @author AlexKazmirchuk
 * @since 13.03.17.
 */

@Service
public class ConversationDetailsService extends
        CommonService<ConversationDetailsEntity,ConversationDetailsRepository> {
}
