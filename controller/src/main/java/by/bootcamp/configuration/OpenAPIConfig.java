package by.bootcamp.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Bootcamp")
                .description("API to use this pat project.")
                .version("1.0")
                .license(apiLicence());
    }

    private License apiLicence() {
        return new License()
                .name("Apache 2.0")
                .url("https://springdoc.org");
    }
}
