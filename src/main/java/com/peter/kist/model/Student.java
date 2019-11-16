package com.peter.kist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "studentId")
@DiscriminatorValue("Student")
@Table(name = "pr_student")
public class Student extends Person {

    private String bookNumber;

    private String note;

    private Date groupPuttingDate;


    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "pr_student_group",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )
    private List<Group> groups;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "pr_student_marks",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "mark_id")}
    )
    private List<Mark> marks;
}
