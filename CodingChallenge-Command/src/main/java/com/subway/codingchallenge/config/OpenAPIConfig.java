package com.subway.codingchallenge.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
	final String securitySchemeName = "bearerAuth";
	@Bean
	public OpenAPI springShopOpenAPI() {

		return new OpenAPI()
				.info(infoAPI())
				.addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
				.components(SecuritySchemeComponent());

	}

	public Info infoAPI() {
		return new Info().title("Spring Security 5 ")
				.description("workshop")
				.contact(contactAPI());
	}

	public Contact contactAPI() {
		Contact contact = new Contact().name("Nawress RAFRAFI")
				.email("rafrafinawress@gmail.com")
				.url("https://www.linkedin.com/in/nawress-rafrafi");
		return contact;
	}

	public Components SecuritySchemeComponent() {
		return new Components()
				.addSecuritySchemes(securitySchemeName,new SecurityScheme()
						.type(SecurityScheme.Type.HTTP)
						.scheme("bearer")
						.bearerFormat("JWT")
						.in(SecurityScheme.In.HEADER).name("authorization"));
	}

	@Bean
	public GroupedOpenApi authApi() {
		return GroupedOpenApi.builder()
				.group("Only Auth Management API")
				.pathsToMatch("/api/auth/**")
				.pathsToExclude("**")
				.build();
	}

	@Bean
	public GroupedOpenApi otherPublicApi() {
		return GroupedOpenApi.builder()
				.group("Other Management API")
				.pathsToMatch("/**")
				.pathsToExclude("/api/auth/**")
				.build();
	}





}
