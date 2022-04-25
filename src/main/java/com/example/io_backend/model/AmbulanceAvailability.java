package com.example.io_backend.model;

import com.example.io_backend.model.enums.AvailabilityType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ambulance_availability")
@Entity
public class AmbulanceAvailability {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ambulance_id")
    private Ambulance ambulance;

    @Enumerated
    @Column(name = "availability_type")
    private AvailabilityType availabilityType;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_start")
    private LocalDate dateStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "details")
    private String details;

}
