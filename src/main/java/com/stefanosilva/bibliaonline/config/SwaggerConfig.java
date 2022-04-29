package com.stefanosilva.bibliaonline.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//http://localhost:8080/swagger-ui/index.html
//https://stackoverflow.com/questions/37671125/how-to-configure-spring-security-to-allow-swagger-url-to-be-accessed-without-aut
//https://medium.com/javarevisited/api-documentation-using-swagger-3-with-spring-boot-2-spring-security-5a0d2b0996ee
@Configuration
public class SwaggerConfig {
        public static final String AUTHORIZATION_HEADER = "Authorization";

        private ApiInfo apiInfo() {
            return new ApiInfo("BibliaOnline Rest APIs",
                    "APIs for BibliaOnline.",
                    "1.0",
                    "Terms of service",
                    new Contact("Stefano", "https://github.com/stefano2007", "stefano_2007@hotmail.com"),
                    "License of API",
                    "API license URL",
                    Collections.emptyList());
        }

        @Bean
        public Docket api() {
            return new Docket(DocumentationType.OAS_30)
                    .apiInfo(apiInfo())
                    .securityContexts(Arrays.asList(securityContext()))
                    .securitySchemes(Arrays.asList(apiKey()))
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.stefanosilva.bibliaonline.resources"))
                    .paths(PathSelectors.any())
                    .build();
        }

        private ApiKey apiKey() {
            return new ApiKey(AUTHORIZATION_HEADER, "JWT", "header");
        }

        private SecurityContext securityContext() {
            return SecurityContext.builder()
                    .securityReferences(defaultAuth())
                    .build();
        }

        List<SecurityReference> defaultAuth() {
            AuthorizationScope authorizationScope
                    = new AuthorizationScope("global", "accessEverything");
            AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
            authorizationScopes[0] = authorizationScope;
            return Arrays.asList(new SecurityReference(AUTHORIZATION_HEADER, authorizationScopes));
        }
    }