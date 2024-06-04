package com.OS.api.products.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

   @Bean
   public OpenAPI customOpenAPI() {
      return new OpenAPI()
              .info(new Info()
                            .title("Online Store API")
                            .version("1.0")
                            .description("This is an ecommerce API")
                            .termsOfService("https://www.linkedin.com/in/antonio-canteros/")
                            .contact(new Contact().name("Anto")
                                                  .email("anronio.canteros.alberto@gmail.com")
                                                  .url("http://example.com"))
                            .license(new License().name("Apache 2.0").url("http://springdoc.org")));
   }
}


