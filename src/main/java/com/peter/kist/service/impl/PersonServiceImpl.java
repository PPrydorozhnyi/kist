package com.peter.kist.service.impl;

import com.peter.kist.model.Person;
import com.peter.kist.repository.PersonRepository;
import com.peter.kist.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        if (person.getId() != null) {
            person = updatePerson(person);
        }
        return personRepository.save(person);
    }

    @Override
    public Person editPerson(Person student) {
        return personRepository.save(student);
    }

    @Override
    public Person getPerson(Integer id) {
        return personRepository.getOne(id);
    }

    @Override
    public void deletePerson(Integer id) {
        Person person = personRepository.getOne(id);
        personRepository.delete(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    private Person updatePerson(Person person) {
        Person personFromCache = personRepository.getOne(person.getId());
        BeanUtils.copyProperties(person, personFromCache, "id", "lessons", "teacherPlans",
                "violations", "personPrivilege", "groups", "marks");
        return personFromCache;
    }

}
