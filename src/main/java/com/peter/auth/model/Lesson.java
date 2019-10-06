package com.peter.auth.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pr_lesson")
public class Lesson {

    @Id
    @Column(name = "lesson_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacherId", nullable = false)
    @EqualsAndHashCode.Exclude
    private Person teacher;

    @ManyToOne
    @JoinColumn(name = "lessonKindId", nullable = false)
    @EqualsAndHashCode.Exclude
    private LessonKind lessonKind;

}
