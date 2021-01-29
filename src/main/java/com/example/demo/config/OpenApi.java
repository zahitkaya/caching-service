package com.example.demo.config;

import com.example.demo.domain.SwaggerPageable;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SpringDocUtils;
import org.springdoc.core.converters.AdditionalModelsConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

import javax.annotation.PostConstruct;

import static org.springdoc.core.SpringDocUtils.getConfig;

@Configuration
@RequiredArgsConstructor
public class OpenApi {



    static {
        getConfig().replaceWithClass(org.springframework.data.domain.Pageable.class,
                org.springdoc.core.converters.models.Pageable.class);
    }


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("Student API")
                .description("Sample Student Api Server  ")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0")
                        .url("http://springdoc.org")));
    }


}

