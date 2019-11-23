package com.peter.kist.service.impl;

import com.peter.kist.model.entity.Person;
import com.peter.kist.model.entity.Student;
import com.peter.kist.repository.PersonRepository;
import com.peter.kist.repository.StudentRepository;
import com.peter.kist.service.QueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QueryServiceImpl implements QueryService {

    private final StudentRepository studentRepository;

    private final PersonRepository personRepository;

    @Override
    public List<Student> query1(Integer groupId) {
        return studentRepository.studentWithMarksMoreThanAverage(groupId);
    }

    @Override
    public List<Person> query2(Date startDate, Date endDate, Integer subjectId) {

        return personRepository.findPersonBySubjectAndSemester(startDate, endDate, subjectId)
                .stream()
                .filter(person -> !Student.class.equals(person.getClass()))
                .collect(Collectors.toList());
    }

    @Override
    public void query3() {

    }

    @Override
    public void query4() {

    }
}
