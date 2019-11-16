package com.peter.kist.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
public class GroupDTO {

    private Integer id;

    @Length(max = 10)
    private String groupCode;

    private Date groupCreateDate;
}
