package com.peter.kist.service.impl;

import com.peter.kist.model.entity.PunishKind;
import com.peter.kist.repository.PunishKindRepository;
import com.peter.kist.service.PunishKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PunishKindServiceImpl implements PunishKindService {
    private final PunishKindRepository punishKindRepository;

    @Override
    public PunishKind createPunishKind(PunishKind mark) {
        return punishKindRepository.save(mark);
    }

    @Override
    public PunishKind editPunishKind(PunishKind mark) {
        return punishKindRepository.save(mark);
    }

    @Override
    public PunishKind getPunishKind(Integer id) {
        return punishKindRepository.getOne(id);
    }

    @Override
    public void deletePunishKind(Integer id) {
        punishKindRepository.deletePunishKindById(id);
    }

    @Override
    public List<PunishKind> findAll() {
        return punishKindRepository.findAll();
    }
}
