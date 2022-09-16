package com.spring.bookmydr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
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
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();	
				}
ApiInfo apiInfo() {
	return new ApiInfoBuilder()
			.title("Book My Doctor App")
			.description("Its a Restful Api to create Online Booking Application")
			.license("Apache 2.0")
			.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
			.termsOfServiceUrl("123").version("1.0.0")
			.contact(new Contact(": Cool People!!! Team3","abc@doctor","contact@contact.com.uy"))
			.build();
}
}
