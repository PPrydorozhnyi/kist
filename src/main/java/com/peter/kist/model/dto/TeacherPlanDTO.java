package com.peter.kist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherPlanDTO {
    private Integer id;
    private Date testDate;

    private Boolean obligatory;

    private SemesterDTO semester;
    private GroupDTO group;
    private PersonDTO tester;
    private TestKindDTO testKind;
    private SubjectDTO subject;

    public TeacherPlanDTO(SemesterDTO semester, GroupDTO group, PersonDTO tester, TestKindDTO testKind, SubjectDTO subject) {
        this.semester = semester;
        this.group = group;
        this.tester = tester;
        this.testKind = testKind;
        this.subject = subject;
    }
}
