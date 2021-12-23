package cl.teamweichafe.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    public static final Contact CONTACT =  new Contact()
            .name("Italo Honorato")
            .url("https://www.linkedin.com/in/italohonorato/")
            .email("italohonorato@gmail.com");
    public static final License LINCENSE = new License()
            .name("Apache 2.0")
            .url("http://springdoc.org");

    public static final Info INFO = new Info()
            .title("Member-Service")
            .description("Spring Boot API to manage Team Weichafe Members")
            .contact(CONTACT)
            .version("v0.0.1")
            .license(LINCENSE);

    @Bean
    public OpenAPI measureServiceOpenAPI() {
        return new OpenAPI()
                .info(INFO);
    }
}
