package com.peter.kist.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
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
