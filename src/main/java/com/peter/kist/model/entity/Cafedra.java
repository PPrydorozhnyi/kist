package com.peter.kist.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pr_cafedra")
public class Cafedra {

    @Id
    @Column(name = "cafedra_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cafedra_name")
    @Length(max = 50)
    private String name;

    @Column(name = "cafedra_shifr")
    @Length(max = 20)
    private String shifr;

    @OneToMany(mappedBy = "cafedra", cascade = CascadeType.ALL)
    private List<Speciality> specialities;
}
