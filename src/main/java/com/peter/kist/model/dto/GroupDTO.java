package com.peter.kist.model.dto;

import com.peter.kist.model.entity.Speciality;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
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
