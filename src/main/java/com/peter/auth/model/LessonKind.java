package com.peter.auth.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "pr_lesson_kind")
public class LessonKind {

    @Id
    @Column(name = "lesson_kind_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lesson_kind_name")
    private String name;

    @OneToMany(mappedBy = "lessonKind")
    @EqualsAndHashCode.Exclude
    private List<Lesson> lessons;
}
