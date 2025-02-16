package com.peter.kist.controller;

import com.peter.kist.model.dto.PunishKindDTO;
import com.peter.kist.model.entity.PunishKind;
import com.peter.kist.service.PunishKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.peter.kist.AppConstants.PUNISH_KIND_DTO_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/punish-kind")
public class PunishKindController {

    private final PunishKindService punishKindService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getPunishKind(Model model, @PathVariable Integer id) {

        log.debug("getPunishKind");

        PunishKind punishKind = punishKindService.getPunishKind(id);

        model.addAttribute("punishKindForm", mapper.map(punishKind, PunishKindDTO.class));

        return "punish-kind/punishKindView";
    }

    @GetMapping("/create")
    public String createPunishKind(Model model) {

        log.debug("createPunishKind");

        model.addAttribute("punishKindForm", new PunishKindDTO());

        return "punish-kind/punishKindCreation";
    }

    @PostMapping("/create")
    public String createPunishKind(@ModelAttribute("punishKindForm") PunishKindDTO punishKindForm, BindingResult bindingResult) {

        log.debug("PunishKind creation");

        PunishKind punishKind = mapper.map(punishKindForm, PunishKind.class);

        punishKind = punishKindService.createPunishKind(punishKind);

        return "redirect:/punish-kind/" + punishKind.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("punishKindForm") PunishKindDTO punishKind, Model model) {
        log.debug("editPunishKind");

        return "punish-kind/punishKindCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deletePunishKind");

        punishKindService.deletePunishKind(id);

        return "redirect:/punish-kind/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllPunishKind");

        List<PunishKind> punishKind = punishKindService.findAll();

        model.addAttribute("punishKind", mapper.map(punishKind, PUNISH_KIND_DTO_LIST_TYPE));

        return "punish-kind/punishKindTableView";
    }
}
