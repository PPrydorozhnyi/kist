package com.peter.kist.service;

import com.peter.kist.model.entity.Violation;

import java.util.List;

public interface ViolationService {

    Violation createViolation(Violation violation);

    Violation editViolation(Violation violation);

    Violation getViolation(Integer id);

    void deleteViolation(Integer id);

    List<Violation> findAll();
}
