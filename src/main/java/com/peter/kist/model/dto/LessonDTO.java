package com.peter.kist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {
    private Integer id;
    private Integer hours;

    private PersonShortDTO teacher;
    private LessonKindDTO lessonKind;

}
