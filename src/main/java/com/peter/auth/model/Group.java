package com.peter.auth.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "pr_groups")
public class Group {

    @Id
    @Column(name = "group_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 10)
    private String groupCode;

    private Date groupCreateDate;

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    private List<Student> students;
}
