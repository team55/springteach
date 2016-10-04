package ru.team55.mes_eds_admin.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//This annotation tells Spring Boot to configure JPA repositories and entities from the current package.
@EnableAutoConfiguration
@ComponentScan("ru.team55.mes_eds_admin")
public class ApplicationConfig {
    //можно напихать бинов, но просканирует конфигу и подтянет необходимое
}
