package com.peter.kist.service;

import com.peter.kist.model.entity.Person;
import com.peter.kist.model.entity.Student;

import java.util.Date;
import java.util.List;

public interface QueryService {

    List<Student> query1(Integer groupId);

    List<Person> query2(Date startDate, Date endDate, Integer subjectId);

    void query3();

    void query4();
}
