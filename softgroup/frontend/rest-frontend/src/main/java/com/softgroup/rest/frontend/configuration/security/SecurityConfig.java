package com.softgroup.rest.frontend.configuration.security;

import com.softgroup.rest.frontend.filters.TokenAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // todo configurate properly
        http
                .addFilterBefore(new TokenAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/", "/api/public/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();

    }
}