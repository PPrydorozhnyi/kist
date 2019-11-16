package com.peter.kist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
//
//    @JoinTable(
//            name = "pr_subject",
//            joinColumns = {@JoinColumn(name = "student_id")},
//            inverseJoinColumns = {@JoinColumn(name = "mark_id")}
//    )
//    private List<Mark> marks;

}
