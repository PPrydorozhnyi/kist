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
@Table(name = "pr_teacher_plan")
public class TeacherPlan {
    @Id
    @Column(name = "teacher_plan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "teacherPlan", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<StudentMark> studentMarks;

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

    @ManyToOne
    @JoinColumn(name = "subjectId", nullable = false)
    @EqualsAndHashCode.Exclude
    private Subject subject;

    @OneToMany(mappedBy = "teacherPlan", fetch = FetchType.LAZY, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private List<Lesson> lesson;
}
