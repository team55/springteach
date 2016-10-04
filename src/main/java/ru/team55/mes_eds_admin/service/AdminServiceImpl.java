package ru.team55.mes_eds_admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.team55.mes_eds_admin.entity.Maintenance;
import ru.team55.mes_eds_admin.repository.MaintenanceRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private MaintenanceRepository repository;

    @Override
    @Cacheable(value="maintenances", key="#maintenance_id") //аспект
    public List<Maintenance> getAll() {
        return repository.findAll();
    }

    @Override
    public Maintenance getByID(int id) {
        return repository.findOne(id);
    }

    @Override
    public Maintenance save(Maintenance maintenance) {
        return repository.saveAndFlush(maintenance);
    }

    @Override
    public void remove(int id) {
        repository.delete(id);
    }



    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional //по сути это аспект которы создаст прокси
    public void create(Maintenance maintenance) {
            entityManager.persist(maintenance);
    }
}
