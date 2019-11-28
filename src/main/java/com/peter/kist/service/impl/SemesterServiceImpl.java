package com.peter.kist.service.impl;

import com.peter.kist.model.entity.Semester;
import com.peter.kist.repository.SemesterRepository;
import com.peter.kist.service.SemesterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SemesterServiceImpl implements SemesterService {

    private final SemesterRepository semesterRepository;

    @Override
    public Semester createSemester(Semester semester) {
        if (semester.getId() != null) {
            semester = updateSemester(semester);
        }
        return semesterRepository.save(semester);
    }

    private Semester updateSemester(Semester semester) {
        final Semester semesterFromCache = semesterRepository.getOne(semester.getId());
        BeanUtils.copyProperties(semester, semesterFromCache, "id", "teacherPlans");
        return semesterFromCache;
    }

    @Override
    public Semester editSemester(Semester semester) {
        return semesterRepository.save(semester);
    }

    @Override
    public Semester getSemester(Integer id) {
        return semesterRepository.getOne(id);
    }

    @Override
    public void deleteSemester(Integer id) {
        semesterRepository.deleteSemesterById(id);
    }

    @Override
    public List<Semester> findAll() {
        return semesterRepository.findAll();
    }

}
