package com.peter.auth.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "pr_student")
public class Student extends Person {
    @Id
    @Column(name = "student_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bookNumber;

    private String note;

    private Date groupPuttingDate;

    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "personId")
    private Person person;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "pr_student_group",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )
    private List<Group> groups;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "pr_student_marks",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "mark_id")}
    )
    private List<Mark> marks;
}
