package com.peter.kist.model.dto;

import lombok.Data;

@Data
public class LessonDTO {
    private Integer id;
    private PersonDTO teacher;
    private LessonKindDTO lessonKind;
    private Integer hours;

    public LessonDTO(PersonDTO person, LessonKindDTO lessonKind){
        this.teacher = person;
        this.lessonKind = lessonKind;
    }
}
