package com.example.io_backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Table(name = "victim")
@Entity
public class Victim {
    @Id
    @Column(name = "victim_id", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "medical_info_id")
    private MedicalInfo medicalInfo;

    @ManyToMany(mappedBy = "victims")
    private Set<ReportSurvey> reportSurveys;
}
