package com.peter.kist.service;

import com.peter.kist.model.entity.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person editPerson(Person person);

    Person getPerson(Integer id);

    void deletePerson(Integer id);

    List<Person> findAll();

}
