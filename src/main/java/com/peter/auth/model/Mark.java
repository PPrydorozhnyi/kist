package com.peter.auth.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "pr_mark")
public class Mark {

    @Id
    @Column(name = "mark_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mark_name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "marks")
    @EqualsAndHashCode.Exclude
    private List<Student> students;
}
