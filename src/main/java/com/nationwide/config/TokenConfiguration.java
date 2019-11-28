package com.nationwide.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Integrates swagger 2 into the project.
 * 
 * Defines the Docket bean and finds a way to control the endpoints exposed by Swagger.
 * 
 * Predicates for selection of RequestHandlers can be configured
 *  with the help of RequestHandlerSelectors and PathSelectors. Using
 *   any() for both will make documentation for your entire API available through Swagger.
 * 
 * @author n/a
 *
 */
@Configuration
@EnableSwagger2
public class TokenConfiguration {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	
}
