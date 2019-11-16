package com.peter.kist.service;

import com.peter.kist.model.entity.Lesson;

import java.util.List;

public interface LessonService {

    Lesson createLesson(Lesson lesson);

    Lesson editLesson(Lesson lesson);

    Lesson getLesson(Integer id);

    void deleteLesson(Integer id);

    List<Lesson> findAll();
}
