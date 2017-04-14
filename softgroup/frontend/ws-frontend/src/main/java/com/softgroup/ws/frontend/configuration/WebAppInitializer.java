package com.softgroup.ws.frontend.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author AlexKazmirchuk
 * @since 14.04.17.
 */

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{};
    }

    @Override
    public Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebSocketConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
