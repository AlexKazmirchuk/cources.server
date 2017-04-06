package com.softgroup.common.validation.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author AlexKazmirchuk
 * @since 06.04.17.
 */

@Configuration
@ComponentScan(basePackages = "com.softgroup.common.validation",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = Configuration.class))
public class RequestValidationServiceAppCfg {
}
