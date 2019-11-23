package com.peter.kist.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "pr_lesson")
public class Lesson {

    @Id
    @Column(name = "lesson_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacherId", nullable = false)
    private Person teacher;

    @ManyToOne
    @JoinColumn(name = "lessonKindId", nullable = false)
    private LessonKind lessonKind;

    @Column(name = "hours")
    private Integer hours;

    @ManyToOne
    @JoinColumn(name = "teacherPlanId", nullable = false)
    private TeacherPlan teacherPlan;
}
