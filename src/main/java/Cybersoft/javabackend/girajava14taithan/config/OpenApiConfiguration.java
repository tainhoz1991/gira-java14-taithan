package Cybersoft.javabackend.girajava14taithan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration // De no biet day la config se tu dong them vo khi run
public class OpenApiConfiguration {
	
	@Value("${api.info.title}") String title;
	@Bean
	public OpenAPI getOpenApi() {
		return new OpenAPI()
		.info(new Info().title(title)
		.description("Spring shop sample application")
		.version("v0.0.1")
		.license(new License().name("Apache 2.0").url("http://springdoc.org")))
		.externalDocs(new ExternalDocumentation()
		.description("SpringShop Wiki Documentation")
		.url("https://springshop.wiki.github.org/docs"));
		
	}

}
