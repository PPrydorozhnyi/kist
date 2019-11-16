package com.peter.kist.service.impl;

import com.peter.kist.model.Semester;
import com.peter.kist.repository.SemesterRepository;
import com.peter.kist.service.SemesterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        return semesterRepository.save(semester);
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
        Semester semester = semesterRepository.getOne(id);
        semesterRepository.delete(semester);
    }

    @Override
    public List<Semester> findAll() {
        return semesterRepository.findAll();
    }

//    @Override
//    public List<Group> getGroupsForSemester(Integer id) {
//        Semester semester = semesterRepository.getOne(id);
//        return semester.getGroups();
//    }

}
