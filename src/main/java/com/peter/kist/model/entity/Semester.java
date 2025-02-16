package com.peter.kist.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pr_semester")
public class Semester {

    @Id
    @Column(name = "semester_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date teachBeginDate;

    private Date teachEndDate;

    private Date sessionBeginDate;

    private Date sessionEndDate;

    @Column(name = "attest1_date")
    private Date attest1Date;

    @Column(name = "attest2_date")
    private Date attest2Date;

    @OneToMany(mappedBy = "semester", orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private List<TeacherPlan> teacherPlans;
}
