package com.peter.kist.service.impl;

import com.peter.kist.model.entity.Lesson;
import com.peter.kist.repository.LessonRepository;
import com.peter.kist.service.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    @Override
    public Lesson createLesson(Lesson lesson) {

        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson editLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson getLesson(Integer id) {
        return lessonRepository.getOne(id);
    }

    @Override
    public void deleteLesson(Integer id) {
        lessonRepository.deleteLessonById(id);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

}
