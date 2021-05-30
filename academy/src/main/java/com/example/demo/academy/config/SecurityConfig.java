package com.example.demo.academy.config;


import com.microsoft.azure.spring.autoconfigure.aad.AADAuthenticationProperties;
import com.microsoft.azure.spring.autoconfigure.aad.ServiceEndpointsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AADAuthenticationProperties aadAuthProps;
    @Autowired
    private ServiceEndpointsProperties serviceEndpointsProps;

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .authorizeRequests()
                .mvcMatchers("/api/students")
                .hasAnyRole("group1", "group2")
                .mvcMatchers("/api/coaches")
                .hasRole("group1")
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .userInfoEndpoint();
             //   .oidcUserService(customADOAuth2UserService());
    }



}