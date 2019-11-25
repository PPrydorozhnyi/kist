package com.peter.kist.service.impl;

import com.peter.kist.model.entity.Mark;
import com.peter.kist.model.entity.Student;
import com.peter.kist.repository.MarkRepository;
import com.peter.kist.repository.StudentRepository;
import com.peter.kist.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final MarkRepository markRepository;

    @Override
    public Student createStudent(Student student) {
        if (student.getId() != null) {
            student = updateStudent(student);
        }
        return studentRepository.save(student);
    }

    @Override
    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Integer id) {
        return studentRepository.getOne(id);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteStudentById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Mark> getMarksForStudent(Integer id) {
        return markRepository.findMarksByStudentId(id);
    }

    private Student updateStudent(Student person) {
        Student personFromCache = studentRepository.getOne(person.getId());
        BeanUtils.copyProperties(person, personFromCache, "id", "lessons", "teacherPlans",
                "violations", "personPrivilege");
        return personFromCache;
    }

}
