package com.peter.kist.model.dto;

import com.peter.kist.model.enums.Sex;
import lombok.Data;

import java.util.Date;

@Data
public class PersonDTO {

    private Integer id;

    private String name;

    private String surname;

    private Sex sex;

    private String address;

    private Date birthDate;

    private String birthPlace;

    private String telephoneNumber;

}
