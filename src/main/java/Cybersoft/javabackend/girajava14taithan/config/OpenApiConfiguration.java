package Cybersoft.javabackend.girajava14taithan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration // De no biet day la config se tu dong them vo khi run
public class OpenApiConfiguration {
	
	@Value("${api.info.title}") String title;
	@Bean
	public OpenAPI getOpenApi() {
		return new OpenAPI()
		.info(new Info().title(title)
		.description("Gira Application for Education Purpose")
		.version("v0.0.1")
		.license(new License().name("NO LICENSE").url("http://taithan.dev"))
		.contact(new Contact()
				.email("")
				.name("")
				.url("")
				)
		)
		.externalDocs(new ExternalDocumentation()
		.description("Spring Documentation")
		.url("https://docs.spring.io/spring-framework/docs/current/reference/html/"));
		
	}

}
