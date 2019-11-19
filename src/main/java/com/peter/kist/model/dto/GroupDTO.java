package com.peter.kist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDTO {

    private Integer id;

    @Length(max = 10)
    private String groupCode;

    private Date groupCreateDate;

    private SpecialityShortDTO speciality;

    public GroupDTO(SpecialityShortDTO speciality) {
        this.speciality = speciality;
    }
}
