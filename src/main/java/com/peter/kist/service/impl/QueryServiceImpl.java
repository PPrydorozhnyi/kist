package com.peter.kist.service.impl;

import com.peter.kist.model.entity.Student;
import com.peter.kist.repository.StudentRepository;
import com.peter.kist.service.QueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QueryServiceImpl implements QueryService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> query1(Integer groupId, Integer subjectId) {
        return studentRepository.customQuery1(groupId, subjectId);
    }

    @Override
    public void query2() {

    }

    @Override
    public void query3() {

    }

    @Override
    public void query4() {

    }
}
