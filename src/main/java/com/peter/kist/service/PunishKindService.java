package com.peter.kist.service;

import com.peter.kist.model.PunishKind;

import java.util.List;

public interface PunishKindService {

    PunishKind createPunishKind(PunishKind mark);

    PunishKind editPunishKind(PunishKind mark);

    PunishKind getPunishKind(Integer id);

    void deletePunishKind(Integer id);

    List<PunishKind> findAll();
}
