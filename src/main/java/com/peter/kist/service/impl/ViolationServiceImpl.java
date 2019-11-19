package com.peter.kist.service.impl;

import com.peter.kist.model.entity.Violation;
import com.peter.kist.repository.ViolationRepository;
import com.peter.kist.service.ViolationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ViolationServiceImpl implements ViolationService {

    private final ViolationRepository violationRepository;

    @Override
    public Violation createViolation(Violation violation) { return violationRepository.save(violation); }

    @Override
    public Violation editViolation(Violation violation) {
        return violationRepository.save(violation);
    }

    @Override
    public Violation getViolation(Integer id) {
        return violationRepository.getOne(id);
    }

    @Override
    public void deleteViolation(Integer id) {
        Violation violation = violationRepository.getOne(id);
        violationRepository.delete(violation);
    }

    @Override
    public List<Violation> findAll() {
        return violationRepository.findAll();
    }
}
