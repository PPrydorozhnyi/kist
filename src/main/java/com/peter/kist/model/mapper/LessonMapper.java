package com.peter.kist.model.mapper;

import com.peter.kist.model.dto.LessonDTO;
import com.peter.kist.model.entity.Lesson;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LessonMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void init() {
        instanceToDtoSetup();
    }

    private void instanceToDtoSetup() {
        mapper.createTypeMap(Lesson.class, LessonDTO.class).setConverter(context -> {
            Lesson lesson = context.getSource();
            if (Objects.isNull(lesson)) {
                return null;
            }
            LessonDTO lessonDTO = new LessonDTO();

            lessonDTO.setId(lesson.getId());
            lessonDTO.setTeacherId(lesson.getTeacher().getId());
            lessonDTO.setLessonKindId(lesson.getLessonKind().getId());
            lessonDTO.setHours(lesson.getHours());

            return lessonDTO;
        });
    }
}
