package com.peter.kist.model.dto;

import com.peter.kist.model.entity.TeacherPlan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentMarkDTO {
    private Integer id;

    private MarkDTO mark;
    private TeacherPlanDTO teacherPlan;
    private StudentDTO student;

    public StudentMarkDTO(MarkDTO mark, StudentDTO student, TeacherPlanDTO teacherPlan) {
        this.mark = mark;
        this.student = student;
        this.teacherPlan = teacherPlan;
    }

}
