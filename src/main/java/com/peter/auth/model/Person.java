package com.peter.auth.model;

import com.peter.auth.model.type.PostgreEnumType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
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

}
