package com.peter.kist.service.impl;

import com.peter.kist.model.entity.Person;
import com.peter.kist.model.entity.Student;
import com.peter.kist.model.enums.MarkNames;
import com.peter.kist.repository.PersonRepository;
import com.peter.kist.repository.StudentRepository;
import com.peter.kist.service.QueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

        return personRepository.findPersonBySubjectAndSemester(startDate, endDate, subjectId);
    }

    @Override
    public List<Student> query3(Integer personId, MarkNames mark) {
        return studentRepository.studentWithMarks(mark.getMin(), mark.getMax(), personId);
    }

    @Override
    public List<Student> queryVadim1(Integer groupId){
        return studentRepository.studentWithMarksMoreThanAverageFromOneGroup(groupId);
    }

    @Override
    public List<Student> queryVadim2(Integer violationKindId){
        return studentRepository.studentWithOneViolationKind(violationKindId);
    }

    @Override
    public List<Student> queryVadim3(){
        return studentRepository.studentThirdQuery();
    }

    @Override
    public List<Student> queryY1(Integer privilegeId, Date privBeginDate, Date privEndDate) {
        return studentRepository.getStudentsByPrivilegeAndBeginAndEnd(privilegeId, privBeginDate, privEndDate);
    }

    @Override
    public List<Student> queryY2(Date violationDate, Date orderDate) {
        return studentRepository.getStudentsByViolationDate(violationDate, orderDate);
    }
}
