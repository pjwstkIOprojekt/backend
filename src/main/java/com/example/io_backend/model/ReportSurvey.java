package com.example.io_backend.model;

import com.example.io_backend.model.enums.BloodType;
import com.example.io_backend.model.enums.EmergencyType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Table(name = "report_survey")
@Entity
public class ReportSurvey {
    @Id
    @Column(name = "report_survey_id", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(name = "victim_breathing")
    private Boolean victimBreathing;

    @Column(name = "victim_conscious")
    private Boolean victimConscious;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "location_id")
    @Column(name = "location")
    private Location location;

    @Column(name = "band")
    @Nullable
    private String bandCode;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EmergencyType emergencyType;

    @Column(name = "victim_count")
    private int victimCount;

    @ManyToMany
    @JoinTable(
            name = "victim",
            joinColumns = @JoinColumn(name = "victim_id"),
            inverseJoinColumns = @JoinColumn(name = "report_survey_id"))
    private Set<Victim> victims;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
