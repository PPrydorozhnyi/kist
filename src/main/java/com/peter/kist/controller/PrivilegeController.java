package com.peter.kist.controller;

import com.peter.kist.model.Group;
import com.peter.kist.model.Privilege;
import com.peter.kist.service.PrivilegeService;
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
@RequiredArgsConstructor(onConstructor_={@Autowired})
@RequestMapping("/privilege")
public class PrivilegeController {

    private final PrivilegeService privilegeService;

    @GetMapping("/{id}")
    public String getPrivilege(Model model, @PathVariable Integer id) {

        log.debug("getPrivilege");

        Privilege privilege = privilegeService.getPrivilege(id);

        model.addAttribute("privilegeForm", privilege);

        return "privilegeView";
    }

    @GetMapping("/create")
    public String createPrivilege(Model model) {

        log.debug("createPrivilege");

        Privilege privilege = new Privilege();

        model.addAttribute("privilegeForm", privilege);

        return "privilegeCreation";
    }

    @PostMapping("/create")
    public String createPrivilege(@ModelAttribute("privilegeForm") Privilege privilegeForm, BindingResult bindingResult) {

        log.debug("Privilege creation");

        if (bindingResult.hasErrors()) {
            return "privilegeCreation";
        }

        privilegeService.createPrivilege(privilegeForm);

        return "redirect:/privilege/" + privilegeForm.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("privilegeForm") Privilege privilege, Model model) {
        log.debug("editPrivilege");

        return "privilegeCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deletePrivilege");

        privilegeService.deletePrivilege(id);

        return "redirect:/privilege/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllPrivilege");

        List<Privilege> privileges = privilegeService.findAll();

        model.addAttribute("privileges", privileges);

        model.addAttribute("deletedUserName", null);

        return "privilegeTableView";
    }
}
