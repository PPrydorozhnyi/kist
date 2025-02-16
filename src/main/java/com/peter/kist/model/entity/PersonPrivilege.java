package com.peter.kist.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "pr_person_privilege")
public class PersonPrivilege {

    @Id
    @Column(name = "person_privilege_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "privilege_id")
    private Privilege privilege;

    @Column(name = "priv_begin_date")
    private Date beginDate;

    @Column(name = "priv_end_date")
    private Date endDate;

    @Length(max = 200)
    private String ground;
}
