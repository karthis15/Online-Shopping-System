package com.example.online_shopping.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Online Shopping Microservices API")
                        .version("1.0.0")
                        .description("API documentation for the Online Shopping Microservices Project.")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact()
                                .name("Karthiswaran")
                                .email("karthiswaran@example.com")
                                .url("http://example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }

    // Configure specific API path
    @Bean
    public GroupedOpenApi productApi() {
        return GroupedOpenApi.builder()
                .group("product-api")
                .pathsToMatch("/api/**") // Matching all APIs under /api/
                .packagesToScan("com.example.online_shopping.rest")
                .build();
    }
}

