package com.peter.kist.model;

import com.peter.kist.model.type.PostgreEnumType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pr_person")
@Inheritance(strategy = InheritanceType.JOINED)
@TypeDef(name = "pg_enum", typeClass = PostgreEnumType.class)
public class Person {
    @Id
    @Column(name = "person_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    @Enumerated(EnumType.STRING)
    @Type(type = "pg_enum")
    private Sex sex;

    private String address;

    private Date birthDate;

    private String birthPlace;

    private String telephoneNumber;

    @Column(name = "person_type", insertable = false, updatable = false)
    private String personType;

    @OneToMany(mappedBy = "teacher")
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "tester")
    private List<TeacherPlan> teacherPlans;

    //Vadim
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Violation> violations;

    //Yarik
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonPrivilege> personPrivilege;

}
