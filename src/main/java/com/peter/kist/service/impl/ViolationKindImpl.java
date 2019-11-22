package com.peter.kist.service.impl;

import com.peter.kist.model.entity.ViolationKind;
import com.peter.kist.repository.ViolationKindRepository;
import com.peter.kist.service.ViolationKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ViolationKindImpl implements ViolationKindService {
    private final ViolationKindRepository violationKindRepository;

    @Override
    public ViolationKind createViolationKind(ViolationKind violationKind) {
        return violationKindRepository.save(violationKind);
    }

    @Override
    public ViolationKind editViolationKind(ViolationKind violationKind) {
        return violationKindRepository.save(violationKind);
    }

    @Override
    public ViolationKind getViolationKind(Integer id) {
        return violationKindRepository.getOne(id);
    }

    @Override
    public void deleteViolationKind(Integer id) {
        violationKindRepository.deleteViolationKindById(id);
    }

    @Override
    public List<ViolationKind> findAll() {
        return violationKindRepository.findAll();
    }
}
