package com.peter.kist.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pr_lesson_kind")
public class LessonKind {

    @Id
    @Column(name = "lesson_kind_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lesson_kind_name")
    private String name;

    @OneToMany(mappedBy = "lessonKind", orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private List<Lesson> lessons;
}
