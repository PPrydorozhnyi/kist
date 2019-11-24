package com.peter.kist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentGroupDTO {

    private Integer id;

    private Date puttingDate;

    private PersonShortDTO student;
    private GroupDTO group;

    public StudentGroupDTO(PersonShortDTO student, GroupDTO group) {
        this.student = student;
        this.group = group;
    }
}
