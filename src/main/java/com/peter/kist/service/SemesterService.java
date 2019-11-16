package com.peter.kist.service;

import com.peter.kist.model.Semester;

import java.util.List;

public interface SemesterService {

    Semester createSemester(Semester semester);

    Semester editSemester(Semester semester);

    Semester getSemester(Integer id);

    void deleteSemester(Integer id);

    List<Semester> findAll();
}
