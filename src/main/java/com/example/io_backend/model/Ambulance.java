package com.example.io_backend.model;

import com.example.io_backend.model.enums.AmbulanceKind;
import com.example.io_backend.model.enums.AmbulanceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Table(name = "ambulance")
@Entity
@AllArgsConstructor
@Builder
public class Ambulance {
    public Ambulance(){}

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "ambulance_type")
    private AmbulanceType ambulanceType;

    @Column(name = "ambulance_kind")
    private AmbulanceKind ambulanceKind;

    /**
     * Fuel tank capacity in milliliters
     */
    @Column(name = "fuel_capacity")
    private Integer fuelCapacity;

    @Column(name = "people_capacity")
    private Integer peopleCapacity;

    @Column(name = "plates")
    private String plates;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ambulance ambulance = (Ambulance) o;
        return id != null && Objects.equals(id, ambulance.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
