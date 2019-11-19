package com.peter.kist.service;

import com.peter.kist.model.entity.Speciality;

import java.util.List;

public interface SpecialityService {
    
    Speciality createSpeciality(Speciality order);

    Speciality editSpeciality(Speciality order);

    Speciality getSpeciality(Integer id);

    void deleteSpeciality(Integer id);

    List<Speciality> findAll();
}
