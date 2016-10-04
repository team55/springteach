package ru.team55.mes_eds_admin.service;

import ru.team55.mes_eds_admin.entity.Maintenance;

import java.util.List;

public interface AdminService {

    List<Maintenance> getAll();
    Maintenance getByID(int id);
    Maintenance save(Maintenance remind);
    void remove(int id);

}
