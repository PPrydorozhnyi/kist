package com.peter.kist.service;

import com.peter.kist.model.Subject;

import java.util.List;

public interface SubjectService {

    Subject createSubject(Subject subject);

    Subject editSubject(Subject subject);

    Subject getSubject(Integer id);

    void deleteSubject(Integer id);

    List<Subject> findAll();

}
