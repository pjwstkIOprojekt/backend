package com.example.io_backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "equipment")
@Entity
public class Equipment {

    public Equipment(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.equipmentLog = new HashSet<>();
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "equipment_id")
    private Set<EquipmentLog> equipmentLog;
}
