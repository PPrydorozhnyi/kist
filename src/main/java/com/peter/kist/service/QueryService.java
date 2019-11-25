package com.peter.kist.service;

import com.peter.kist.model.entity.Person;
import com.peter.kist.model.entity.Student;
import com.peter.kist.model.enums.MarkNames;

import java.util.Date;
import java.util.List;

public interface QueryService {

    List<Student> query1(Integer groupId);

    List<Person> query2(Date startDate, Date endDate, Integer subjectId);

    List<Student> query3(Integer personId, MarkNames mark);

    List<Student> queryVadim1(Integer groupId);

    List<Student> queryVadim2(Integer violationKindId);

    List<Student> queryVadim3();

    List<Student> queryY1(Integer privilegeId, Date privBeginDate, Date privEndDate);

    List<Student> queryY2(Date violationDate, Date orderDate);

    List<Student> queryY3(Integer specialityId, MarkNames mark);
}
