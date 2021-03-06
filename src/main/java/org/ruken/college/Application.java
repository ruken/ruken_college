package org.ruken.college;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import org.apache.log4j.Logger;

/** * Created by azizunsal on 24/02/15. */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableTransactionManagement
@EntityScan(basePackages = {"org.ruken.college.jpa.model"} )
@EnableJpaRepositories(basePackages = {"org.ruken.college.jpa.repository"})
@EnableSwagger2
@SpringBootApplication
public class Application {

	private static final Logger log = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}

class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("org.ruken.college.controller"))
				.paths(regex("/.*"))
				.build();

	}
}
