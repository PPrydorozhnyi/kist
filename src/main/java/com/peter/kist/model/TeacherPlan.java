package com.peter.kist.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pr_teacher_plan")
public class TeacherPlan {
    @Id
    @Column(name = "teacher_plan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "pr_student_marks",
            joinColumns = {@JoinColumn(name = "teacher_plan_id")},
            inverseJoinColumns = {@JoinColumn(name = "mark_id")}
    )
    private List<Mark> marks;

    private Date testDate;

    private Boolean obligatory;

    @ManyToOne
    @JoinColumn(name = "semesterId")
    @EqualsAndHashCode.Exclude
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "groupId")
    @EqualsAndHashCode.Exclude
    private Group group;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "testerId", nullable = false)
    @EqualsAndHashCode.Exclude
    private Person tester;

    @ManyToOne
    @JoinColumn(name = "testKindId", nullable = false)
    @EqualsAndHashCode.Exclude
    private TestKind testKind;
}
