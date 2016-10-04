package ru.team55.mes_eds_admin.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import ru.team55.mes_eds_admin.entity.Maintenance;

@RepositoryEventHandler
@Slf4j
public class MaintenanceEventHandler {

    @HandleBeforeSave
    public void handlePersonSave(Maintenance p) {
        // … you can now deal with Person in a type-safe way
        log.info("Handle before save "+p.toString());
    }

//    @HandleBeforeSave
//    public void handleProfileSave(Profile p) {
//        // … you can now deal with Profile in a type-safe way
//    }
}