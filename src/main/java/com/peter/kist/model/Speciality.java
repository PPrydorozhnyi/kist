package com.peter.kist.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pr_speciality")
public class Speciality {

    @Id
    @Column(name = "speciality_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "speciality_name")
    @Length(max = 50)
    private String name;

    @Column(name = "speciality_shifr")
    @Length(max = 20)
    private String shifr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafedra_id")
    private Cafedra cafedra;

    @OneToMany(mappedBy = "speciality", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Group> groups;

}
