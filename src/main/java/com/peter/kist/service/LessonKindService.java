package com.peter.kist.service;

import com.peter.kist.model.entity.LessonKind;

import java.util.List;

public interface LessonKindService {
    LessonKind createLessonKind(LessonKind lessonKind);

    LessonKind editLessonKind(LessonKind lessonKind);

    LessonKind getLessonKind(Integer id);

    void deleteLessonKind(Integer id);

    List<LessonKind> findAll();
}
