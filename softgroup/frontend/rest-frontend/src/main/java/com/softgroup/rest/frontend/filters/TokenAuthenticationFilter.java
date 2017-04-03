package com.softgroup.rest.frontend.filters;

import com.softgroup.common.jwt.api.TokenService;
import com.softgroup.common.jwt.exceptions.InvalidTokenException;
import com.softgroup.rest.frontend.configuration.security.TokenAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

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

@Component
public class TokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private TokenService tokenService;

    public TokenAuthenticationFilter() {
        setAuthenticationManager(new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                return authentication;
            }
        });
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String xToken = ((HttpServletRequest)req).getHeader("x-token");
        try {
            tokenService.validateSessionToken(xToken);
            String profileID = tokenService.getProfileID(xToken);
            String deviceID = tokenService.getDeviceID(xToken);
            SecurityContextHolder
                    .getContext()
                    .setAuthentication(new TokenAuthentication(profileID,deviceID));
            chain.doFilter(req,res);
        } catch (InvalidTokenException e) {
            ((HttpServletResponse) res).sendError(403);
        }
    }

}
