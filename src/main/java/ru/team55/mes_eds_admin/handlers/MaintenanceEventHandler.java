package ru.team55.mes_eds_admin.handlers;

import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import ru.team55.mes_eds_admin.entity.Maintenance;

@RepositoryEventHandler
public class MaintenanceEventHandler {

    @HandleBeforeSave
    public void handlePersonSave(Maintenance p) {
        // … you can now deal with Person in a type-safe way
    }

//    @HandleBeforeSave
//    public void handleProfileSave(Profile p) {
//        // … you can now deal with Profile in a type-safe way
//    }
}