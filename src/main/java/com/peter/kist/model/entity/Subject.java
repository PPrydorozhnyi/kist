package com.peter.kist.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "pr_subject")
public class Subject {

    @Id
    @Column(name = "subject_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "subject_name")
    private String name;

    @Column(name = "subject_shifr")
    private String code;
}
