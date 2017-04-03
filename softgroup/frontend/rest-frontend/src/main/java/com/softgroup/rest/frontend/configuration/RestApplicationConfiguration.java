package com.softgroup.rest.frontend.configuration;

import com.softgroup.authorization.impl.configuration.AuthorizationImplAppCfg;
import com.softgroup.common.dao.impl.configuration.CommonDaoAppCfg;
import com.softgroup.common.datamapper.configuration.DataMapperAppCfg;
import com.softgroup.common.jwt.configuration.TokenServiceAppCfg;
import com.softgroup.common.router.impl.configuration.FirstRouterAppCfg;
import com.softgroup.messenger.impl.configuration.MessengerImplAppCfg;
import com.softgroup.profile.impl.configuration.ProfileImplAppCfg;
import com.softgroup.rest.frontend.configuration.security.SecurityConfig;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan(basePackages = "com.softgroup.rest.frontend",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = Configuration.class))
@Import(value = {
        DataMapperAppCfg.class,
        AuthorizationImplAppCfg.class,
        ProfileImplAppCfg.class,
        MessengerImplAppCfg.class,
        FirstRouterAppCfg.class,
        TokenServiceAppCfg.class,
        CommonDaoAppCfg.class,
        SecurityConfig.class})

public class RestApplicationConfiguration {

}
