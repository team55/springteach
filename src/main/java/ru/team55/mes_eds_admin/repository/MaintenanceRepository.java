package ru.team55.mes_eds_admin.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.team55.mes_eds_admin.entity.Maintenance;
import ru.team55.mes_eds_admin.handlers.MaintenanceEventHandler;


@RepositoryRestResource(
        collectionResourceRel = "maintenance2",
        path = "maintenance2")

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {

//http://docs.spring.io/spring-data/rest/docs/current/reference/html/#events
//    @Bean
//    MaintenanceEventHandler maintenanceEventHandler() {
//        return new MaintenanceEventHandler();
//    }
}
