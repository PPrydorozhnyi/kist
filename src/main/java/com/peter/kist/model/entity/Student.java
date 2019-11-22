package com.peter.kist.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "studentId")
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

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<StudentMark> studentMarks;
}
