package com.peter.kist.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pr_violation_kind")
public class ViolationKind {

    @Id
    @Column(name = "violation_kind_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 50)
    @Column(name = "violation_kind_name")
    private String name;

    @OneToMany(mappedBy = "violationKind")
    private List<Violation> violations;

}
