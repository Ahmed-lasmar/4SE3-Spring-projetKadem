package com.example.demo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("Spring Kaddem Project").description("TP étude de cas").contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Si Ahmed Lasmar").email("ahmed.lasmar@esprit.tn").url("www.linkedin.com/in/ahmed-lasmar");
        return contact;
    }
}
