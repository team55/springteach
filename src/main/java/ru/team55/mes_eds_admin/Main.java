package ru.team55.mes_eds_admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.team55.mes_eds_admin.config.ApplicationConfig;
import ru.team55.mes_eds_admin.entity.Maintenance;
import ru.team55.mes_eds_admin.service.AdminService;

import java.sql.Timestamp;
import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class Main {

    //todo создание дефлотных юзеров и отслеживание событий и аспектов

    public Main(@Autowired  AdminService service){

        Maintenance maint = new Maintenance();
        maint.setName("MAIN");
        maint.setCreated(new Timestamp(System.currentTimeMillis()));
        service.create(maint);


        service.getByID(1); //читаем
        service.getByID(2); //из кеша
    }


    public static void main(String[] args){
        log.debug("Application starting");

        //todo переводится в режим логирования info - понять как менять
        //вариант 1
//        ConfigurableApplicationContext context = SpringApplication
//                .run(ApplicationConfig.class);
        //Вариант 2
        ConfigurableApplicationContext context = SpringApplication
                .run(Main.class);


        log.info("---================= BEANS ===============---");
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            log.info(beanName);
        }



    }
}
