package com.hit.base_1.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
  @Bean
  public OpenAPI customOpenAPI() {
    OpenAPI openAPI = new OpenAPI().info(
        new Info()
            .title("Class Service API")
            .version("1.0")
            .description("Documentation Class Service API v1.0")
    );

    openAPI.addSecurityItem(new SecurityRequirement().addList("gateway security"));
    openAPI.components(
        new Components()
            .addSecuritySchemes(
                "gateway security",
                new SecurityScheme().name("gateway security").type(SecurityScheme.Type.HTTP).scheme("basic")
            )
    );

    return openAPI;
  }
}
