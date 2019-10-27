package com.zeroout.java.stockpricequery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@SpringBootApplication
public class StockPriceQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPriceQueryApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		// return a prepared Docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/rest/stock/*"))
				.apis(RequestHandlerSelectors.basePackage("com.zeroout"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Stock-Price-Query API",
				"Sample API for JavaBrains tutorial",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Alex Cheng", "http://test","alex@alex.com"),
				"API License",
				"http://testing",
				Collections.emptyList()
		);
	}
}
