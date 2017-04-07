package com.softgroup.common.router.impl.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author AlexKazmirchuk
 * @since 28.02.17.
 */

@Configuration
@ComponentScan(basePackages = "com.softgroup.common.router.impl",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = Configuration.class))
public class FirstRouterAppCfg {
}
