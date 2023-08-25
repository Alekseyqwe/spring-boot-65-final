package com.tms;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@OpenAPIDefinition(
    info = @Info(
            title = "Group 65 project",
        description = "This  is pet project",
        contact = @Contact(
                name = "Aleksey Serak",
                email = "Sserak2007@gmail.com",
                url = "@alekseyserak"

        )
)
)
@SpringBootApplication
@EnableJpaRepositories
public class SpringBoot65FinalApplication {

    static final Logger log = LoggerFactory.getLogger(SpringBoot65FinalApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot65FinalApplication.class, args);
        log.debug("After Starting application DEBUG");
        log.info("After Starting application");
    }
}