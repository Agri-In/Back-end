package com.audit.agriin.Core;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.reactive.function.client.WebClient;

import javax.sql.DataSource;

@Configuration
public class ExtraConfiguration {

    /**
     * Creates an instance of WebClient to be used for OAuth2 token introspection.
     *
     * @return WebClient
     */
    @Bean
    public WebClient userInfoClient() {
        return WebClient.builder().build();
    }

}
