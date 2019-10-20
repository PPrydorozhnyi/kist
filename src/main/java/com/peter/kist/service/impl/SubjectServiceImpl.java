package com.peter.kist.service.impl;

import com.peter.kist.model.Group;
import com.peter.kist.model.Subject;
import com.peter.kist.repository.SubjectRepository;
import com.peter.kist.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject editSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getSubject(Integer id) {
        return subjectRepository.getOne(id);
    }

    @Override
    public void deleteSubject(Integer id) {
        Subject subject = subjectRepository.getOne(id);
        subjectRepository.delete(subject);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    /*@Override
    public List<Group> getGroupsForSubject(Integer id) {
        Subject subject = subjectRepository.getOne(id);
        return subject.getGroups();
    }*/
}
