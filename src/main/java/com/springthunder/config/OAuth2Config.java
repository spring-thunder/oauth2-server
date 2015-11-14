/**
 * OAuth2Config.java - This file is part of Spring Thunder organization.
 * Under License CC0 1.0 Universal 2015.
 */
package com.springthunder.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    /* AuthenticationManager already created with eventual users
     * TIP: Creates your users if you plan to have password grant type token.*/
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .secret("secret")
                        /** Two grant types are handled:
                         * - password: It requires user management creation beforehand
                         * - client_credentials : It just requires client credentials
                         */
                .authorizedGrantTypes("password","client_credentials")
                .scopes("read", "trust")
                .authorities("ROLE_CLIENT");  //AUTHORITIES GRANTED

    }

}
