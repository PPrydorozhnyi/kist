package com.peter.kist.model.dto;

import com.peter.kist.model.enums.Sex;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonDTO extends PersonShortDTO {

    private Sex sex;

    private String address;

    private Date birthDate;

    private String birthPlace;

    private String telephoneNumber;

}
