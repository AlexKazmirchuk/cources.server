package com.softgroup.messenger.impl.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author AlexKazmirchuk
 * @since 02.03.17.
 */

@Configuration
@ComponentScan(basePackages = "com.softgroup.messenger.impl",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = Configuration.class))
public class MessengerImplAppCfg {
}
