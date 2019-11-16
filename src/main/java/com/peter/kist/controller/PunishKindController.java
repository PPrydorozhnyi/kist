package com.peter.kist.controller;

import com.peter.kist.model.PunishKind;
import com.peter.kist.service.PunishKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/punish-kind")
public class PunishKindController {
    private final PunishKindService punishKindService;

    @GetMapping("/{id}")
    public String getPunishKind(Model model, @PathVariable Integer id) {

        log.debug("getPunishKind");

        PunishKind punishKind = punishKindService.getPunishKind(id);

        model.addAttribute("punishKindForm", punishKind);

        return "punishKindView";
    }

    @GetMapping("/create")
    public String createPunishKind(Model model) {

        log.debug("createPunishKind");

        PunishKind punishKind = new PunishKind();

        model.addAttribute("punishKindForm", punishKind);

        return "punishKindCreation";
    }

    @PostMapping("/create")
    public String createPunishKind(@ModelAttribute("punishKindForm") PunishKind punishKindForm, BindingResult bindingResult) {

        log.debug("PunishKind creation");

        if (bindingResult.hasErrors()) {
            return "punishKindCreation";
        }

        punishKindService.createPunishKind(punishKindForm);

        return "redirect:/punish-kind/" + punishKindForm.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("punishKindForm") PunishKind punishKind, Model model) {
        log.debug("editPunishKind");

        return "punishKindCreation";
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

        model.addAttribute("punishKind", punishKind);

        model.addAttribute("deletedUserName", null);

        return "punishKindTableView";
    }
}
