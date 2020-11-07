package com.hcl.net.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.select()
			    .apis(RequestHandlerSelectors.basePackage("com.hcl.net"))
			    .paths(postPaths())
			    .build()
			    .apiInfo(apiInfo());
		/*
		 * .apiInfo(apiInfo()).select() .paths(postPaths()).build().apiInfo(apiInfo());
		 */
	}

	private Predicate<String> postPaths() {
		return or(regex("/*"), regex("/*.*"));
	}
	 @Bean
	 public ApiInfo apiInfo() {

	return new ApiInfoBuilder().title("API Specification is used for Mobile connection service provider  for  Web Application")
				.description("This implementation is used for  Mobile service provider company only ")
				.termsOfServiceUrl("http://www.hcl.com").license("License of API")
				.licenseUrl("http://www.hcl.com").version("1.0").build();

	}
}