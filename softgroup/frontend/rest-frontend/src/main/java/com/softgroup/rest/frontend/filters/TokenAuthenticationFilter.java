package com.softgroup.rest.frontend.filters;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author AlexKazmirchuk
 * @since 18.03.17.
 */

public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {


    protected TokenAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    public TokenAuthenticationFilter(){
        super("/api/private/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        // todo implement later

        return null;
    }
}
