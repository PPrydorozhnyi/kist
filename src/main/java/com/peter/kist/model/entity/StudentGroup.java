package com.peter.kist.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "pr_student_group")
public class StudentGroup {

    @Id
    @Column(name = "student_group_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date puttingDate;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "group_id")
    private Group group;

}
