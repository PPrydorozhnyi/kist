package com.peter.kist.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pr_student_marks")
public class StudentMark {

    @Id
    @Column(name = "student_mark_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "mark_id")
    private Mark mark;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "teacher_plan_id")
    private TeacherPlan teacherPlan;
}
