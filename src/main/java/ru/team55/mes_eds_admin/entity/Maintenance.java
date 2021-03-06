package ru.team55.mes_eds_admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(
    name = "maintenances",
    uniqueConstraints = {@UniqueConstraint(name = "maintenance_name_key",columnNames = {"name"})}
)
@DynamicUpdate //только модифицированые
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Maintenance {

    @Id
    @Column(name = "maintenance_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    private Timestamp created;
}
