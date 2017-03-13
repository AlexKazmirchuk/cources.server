package com.softgroup.common.dao.impl.services;

import com.softgroup.common.dao.api.entities.ConversationSettingsEntity;
import com.softgroup.common.dao.impl.repositories.ConversationSettingsRepository;
import org.springframework.stereotype.Service;

/**
 * @author AlexKazmirchuk
 * @since 13.03.17.
 */

@Service
public class ConversationSettingsService extends
        CommonService<ConversationSettingsEntity,ConversationSettingsRepository> {
}
