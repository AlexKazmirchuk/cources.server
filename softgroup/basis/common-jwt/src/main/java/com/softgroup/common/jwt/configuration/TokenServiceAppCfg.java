package com.softgroup.common.jwt.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author AlexKazmirchuk
 * @since 16.03.17.
 */

@Configuration
@ComponentScan(basePackages = "com.softgroup.common.jwt",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = Configuration.class))
public class TokenServiceAppCfg {
}
