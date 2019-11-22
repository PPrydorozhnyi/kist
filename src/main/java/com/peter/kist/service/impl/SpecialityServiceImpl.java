package com.peter.kist.service.impl;

import com.peter.kist.model.entity.Speciality;
import com.peter.kist.repository.SpecialityRepository;
import com.peter.kist.service.SpecialityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository specialityRepository;

    @Override
    public Speciality createSpeciality(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public Speciality editSpeciality(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public Speciality getSpeciality(Integer id) {
        return specialityRepository.getOne(id);
    }

    @Override
    public void deleteSpeciality(Integer id) {
        specialityRepository.deleteSpecialityById(id);
    }

    @Override
    public List<Speciality> findAll() {
        return specialityRepository.findAll();
    }
}
