package com.example.cricket_backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cricket Backend API")
                        .version("1.0")
                        .description("API documentation for Cricket Backend")
                        .contact(new Contact().name("Madesh A").email("amadesh702@gmail.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );
    }
}
