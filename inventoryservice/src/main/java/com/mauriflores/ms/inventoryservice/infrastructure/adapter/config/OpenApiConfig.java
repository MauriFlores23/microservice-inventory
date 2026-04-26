package com.mauriflores.ms.inventoryservice.infrastructure.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI inventoryServiceAPI() {
        return new OpenAPI()
            .info(new Info()
            .title("Servicios de Inventarios")
            .description("API para administracion de productosd de inventarios")
            .version("1.0.0")
        );
    }

}
