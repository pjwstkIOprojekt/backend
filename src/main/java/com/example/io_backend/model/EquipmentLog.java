package com.example.io_backend.model;

import lombok.*;

import javax.annotation.security.DenyAll;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "equipment_log")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentLog {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "ambulance_id")
    private Ambulance ambulance;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "starting_amount")
    private Double startingAmount;

    @Column(name = "current_amount")
    private Double currentAmount;

    @Column(name = "measurement")
    private String measurement;

}
