package ru.team55.mes_eds_admin.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;

@Slf4j
public class ApplicationListener extends AbstractRepositoryEventListener {

    @Override
    public void onBeforeSave(Object entity) {
    //... logic to handle inspecting the entity before the Repository saves it
        log.info("Before save "+entity.toString());
    }

    @Override
    public void onAfterDelete(Object entity) {
    //... send a message that this entity has been deleted
        log.info("After delete "+entity.toString());
    }
}