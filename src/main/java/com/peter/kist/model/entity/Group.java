package com.peter.kist.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pr_groups")
public class Group {

    @Id
    @Column(name = "group_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 10)
    private String groupCode;

    private Date groupCreateDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private List<StudentGroup> studentGroups;

    @OneToMany(mappedBy = "group")
    private List<TeacherPlan> teacherPlans;

    //Yarik
    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;
}
