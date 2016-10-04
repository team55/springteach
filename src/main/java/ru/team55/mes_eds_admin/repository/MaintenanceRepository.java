package ru.team55.mes_eds_admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.team55.mes_eds_admin.entity.Maintenance;


public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
}
