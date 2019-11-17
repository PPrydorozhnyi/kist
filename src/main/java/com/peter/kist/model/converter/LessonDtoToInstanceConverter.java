package com.peter.kist.model.converter;

import com.peter.kist.model.dto.LessonDTO;
import com.peter.kist.model.entity.Lesson;
import com.peter.kist.repository.LessonKindRepository;
import com.peter.kist.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LessonDtoToInstanceConverter implements Converter<LessonDTO, Lesson> {

    private final PersonRepository personRepository;

    private final LessonKindRepository lessonKindRepository;

    private final ModelMapper mapper;

    @Override
    public Lesson convert(LessonDTO lessonDTO) {

        Lesson lesson = mapper.map(lessonDTO, Lesson.class);

        lesson.setLessonKind(lessonKindRepository.getOne(lessonDTO.getLessonKindId()));
        lesson.setTeacher(personRepository.getOne(lessonDTO.getTeacherId()));

        return lesson;
    }
}
