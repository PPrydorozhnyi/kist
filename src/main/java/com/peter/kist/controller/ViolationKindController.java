package com.peter.kist.controller;

import com.peter.kist.model.dto.ViolationKindDTO;
import com.peter.kist.model.entity.ViolationKind;
import com.peter.kist.service.ViolationKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.peter.kist.AppConstants.VIOLATION_KIND_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/violation-kind")
public class ViolationKindController {

    private final ViolationKindService violationKindService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getViolationKind(Model model, @PathVariable Integer id) {

        log.debug("getViolationKind");

        ViolationKind violationKind = violationKindService.getViolationKind(id);

        model.addAttribute("violationKindForm", mapper.map(violationKind, ViolationKindDTO.class));

        return "violationKindView";
    }

    @GetMapping("/create")
    public String createViolationKind(Model model) {

        log.debug("createViolationKind");

        model.addAttribute("violationKindForm", new ViolationKindDTO());

        return "violationKindCreation";
    }

    @PostMapping("/create")
    public String createViolationKind(@ModelAttribute("violationKindForm") ViolationKindDTO violationKindForm, BindingResult bindingResult) {

        log.debug("ViolationKind creation");

        ViolationKind violationKind = mapper.map(violationKindForm, ViolationKind.class);

        violationKindService.createViolationKind(violationKind);

        return "redirect:/violation-kind/" + violationKind.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("violationKindForm") ViolationKindDTO violationKind, Model model) {
        log.debug("editViolationKind");

        return "violationKindCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteViolationKind");

        violationKindService.deleteViolationKind(id);

        return "redirect:/violation-kind/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllViolationKind");

        List<ViolationKind> violationKind = violationKindService.findAll();

        model.addAttribute("violationKind", mapper.map(violationKind, VIOLATION_KIND_LIST_TYPE));

        model.addAttribute("deletedUserName", null);

        return "violationKindTableView";
    }
}
