package com.peter.kist.repository;

import com.peter.kist.model.entity.PunishKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface PunishKindRepository extends JpaRepository<PunishKind, Integer> {
    @Modifying
    @Transactional
    void deletePunishKindById(Integer id);
}
