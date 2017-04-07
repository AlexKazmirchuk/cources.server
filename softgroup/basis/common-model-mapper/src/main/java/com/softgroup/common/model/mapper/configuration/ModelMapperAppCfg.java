package com.softgroup.common.model.mapper.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author AlexKazmirchuk
 * @since 31.03.17.
 */

@Configuration
@ComponentScan(basePackages = "com.softgroup.common.model.mapper",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = Configuration.class))
public class ModelMapperAppCfg {
}
