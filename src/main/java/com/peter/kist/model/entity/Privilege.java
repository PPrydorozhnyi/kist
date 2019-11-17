package com.peter.kist.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pr_privilege")
public class Privilege {

    @Id
    @Column(name = "privilege_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "privilege_name")
    private String name;

    @OneToMany(mappedBy = "privilege", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonPrivilege> personPrivilege;
}
