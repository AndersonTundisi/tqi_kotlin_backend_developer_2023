package com.jumarket.system.config

import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    /*
    Swagger para a documentação
    localhost:8080/swagger-ui.html
     */
    @Bean
    fun publicApi(): GroupedOpenApi?{
        return GroupedOpenApi.builder()
            .group("springcreditapplicationsystem-public")
            .pathsToMatch("/api/categorias/**", "/api/produtos/**", "/api/carrinhos/**").build()
    }
}