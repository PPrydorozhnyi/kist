package com.peter.kist.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SemesterDTO {
    private Integer id;
    private Date teachBeginDate;
    private Date teachEndDate;
    private Date sessionBeginDate;
    private Date sessionEndDate;
    private Date attest1Date;
    private Date attest2Date;
}
