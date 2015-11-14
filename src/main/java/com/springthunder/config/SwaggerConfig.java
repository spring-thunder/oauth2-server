/**
 * SwaggerConfig.java - This file is part of Spring Thunder organization.
 * Under License CC0 1.0 Universal 2015.
 */
package com.springthunder.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@EnableSwagger
public class SwaggerConfig {
    private SpringSwaggerConfig springSwaggerConfig;
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {

        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
        //This info will be used in Swagger. See realisation of ApiInfo for more details.
                .apiInfo(new ApiInfo(
                        "OAuth API",
                        "This app is for education, training purpose. It represents model of landlords and apartments for rent",
        null,
        null,
        null,
        null
        ))
        //Here we disable auto generating of responses for REST-endpoints
                .useDefaultResponseMessages(false)
        //Here we specify URI patterns which will be included in Swagger docs. Use regex for this purpose.
                .includePatterns("/landlords.*");
    }
}
