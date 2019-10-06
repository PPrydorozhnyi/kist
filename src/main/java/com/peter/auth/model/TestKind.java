package com.peter.auth.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "pr_test_kind")
public class TestKind {

    @Id
    @Column(name = "test_kind_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "test_name")
    private String name;

    @OneToMany(mappedBy = "testKind")
    @EqualsAndHashCode.Exclude
    private List<TeacherPlan> teacherPlan;
}
