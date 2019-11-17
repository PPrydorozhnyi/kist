package com.peter.kist.service;

import com.peter.kist.model.entity.ViolationKind;

import java.util.List;

public interface ViolationKindService {
    ViolationKind createViolationKind(ViolationKind ViolationKind);

    ViolationKind editViolationKind(ViolationKind ViolationKind);

    ViolationKind getViolationKind(Integer id);

    void deleteViolationKind(Integer id);

    List<ViolationKind> findAll();
}
