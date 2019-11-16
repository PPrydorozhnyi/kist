package com.peter.kist.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentDTO extends PersonDTO {

    private String bookNumber;

    private String note;

    private Date groupPuttingDate;
}
