package com.peter.kist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonPrivilegeDTO {

    private Integer id;

    private Date beginDate;

    private Date endDate;

    private String ground;

    private PersonShortDTO person;
    private PrivilegeDTO privilege;

    public PersonPrivilegeDTO(PersonShortDTO person, PrivilegeDTO privilege) {
        this.person = person;
        this.privilege = privilege;
    }
}
