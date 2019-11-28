package com.peter.kist.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pr_test_kind")
public class TestKind {

    @Id
    @Column(name = "test_kind_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "test_name")
    private String name;

    @OneToMany(mappedBy = "testKind", orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private List<TeacherPlan> teacherPlan;
}
