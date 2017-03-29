package com.softgroup.rest.frontend.filters;

import com.softgroup.rest.frontend.configuration.security.TokenAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author AlexKazmirchuk
 * @since 18.03.17.
 */

public class TokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        // todo check token
//        if (token == valid){
//            SecurityContextHolder.getContext().setAuthentication(new TokenAuthentication());
//        }

        chain.doFilter(req,res);
    }
}
