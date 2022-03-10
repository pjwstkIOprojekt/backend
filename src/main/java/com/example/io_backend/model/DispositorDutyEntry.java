package com.example.io_backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "dispositor_duty_entries")
@Entity
public class DispositorDutyEntry {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "duty_start")
    private Long dutyStart;

    @Column(name = "duty_end")
    private Long dutyEnd;

    @Column(name = "comment")
    String comment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

}
