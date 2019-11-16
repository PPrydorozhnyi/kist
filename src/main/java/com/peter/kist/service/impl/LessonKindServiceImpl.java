package com.peter.kist.service.impl;

import com.peter.kist.model.entity.LessonKind;
import com.peter.kist.repository.LessonKindRepository;
import com.peter.kist.service.LessonKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LessonKindServiceImpl implements LessonKindService {

    private final LessonKindRepository lessonKindRepository;

    @Override
    public LessonKind createLessonKind(LessonKind lessonKind) {
        return lessonKindRepository.save(lessonKind);
    }

    @Override
    public LessonKind editLessonKind(LessonKind lessonKind) {
        return lessonKindRepository.save(lessonKind);
    }

    @Override
    public LessonKind getLessonKind(Integer id) {
        return lessonKindRepository.getOne(id);
    }

    @Override
    public void deleteLessonKind(Integer id) {
        LessonKind lessonKind = lessonKindRepository.getOne(id);
        lessonKindRepository.delete(lessonKind);
    }

    @Override
    public List<LessonKind> findAll() {
        return lessonKindRepository.findAll();
    }

    /*@Override
    public List<Group> getGroupsForLessonKind(Integer id) {
        LessonKind lessonKind = lessonKindRepository.getOne(id);
        return lessonKind.getGroups();
    }*/
}
