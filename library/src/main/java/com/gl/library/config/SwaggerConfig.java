package com.gl.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket libraryApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("group-Api").select()
				.apis(RequestHandlerSelectors.basePackage("com.gl.library.controller"))
				.build();
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder().title("library-Api")
				.description("library API reference for developer")
				.termsOfServiceUrl("http://fakelibrary.com")
				.contact(new Contact("library api", "http://fakelibrary.com","fake@gmail.com"))
				.license("library license")
				.licenseUrl("http://fakelibrary.com")
				.version("2.0")
				.build();
	}

}
