package com.peter.kist.controller;

import com.peter.kist.model.dto.PrivilegeDTO;
import com.peter.kist.model.entity.Privilege;
import com.peter.kist.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.peter.kist.AppConstants.PRIVILEGE_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/privilege")
public class PrivilegeController {

    private static final String PRIVILEGE_CREATION_PAGE = "privilegeCreation";

    private final PrivilegeService privilegeService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getPrivilege(Model model, @PathVariable Integer id) {

        log.debug("getPrivilege");

        Privilege privilege = privilegeService.getPrivilege(id);

        model.addAttribute("privilegeForm", mapper.map(privilege, PrivilegeDTO.class));

        return "privilegeView";
    }

    @GetMapping("/create")
    public String createPrivilege(Model model) {

        log.debug("createPrivilege");

        model.addAttribute("privilegeForm", new PrivilegeDTO());

        return PRIVILEGE_CREATION_PAGE;
    }

    @PostMapping("/create")
    public String createPrivilege(@ModelAttribute("privilegeForm") PrivilegeDTO privilegeForm, BindingResult bindingResult) {

        log.debug("Privilege creation");

        Privilege privilege = mapper.map(privilegeForm, Privilege.class);

        if (bindingResult.hasErrors()) {
            return PRIVILEGE_CREATION_PAGE;
        }

        privilegeService.createPrivilege(privilege);

        return "redirect:/privilege/" + privilege.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("privilegeForm") PrivilegeDTO privilege, Model model) {
        log.debug("editPrivilege");

        return PRIVILEGE_CREATION_PAGE;
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

        model.addAttribute("privileges", mapper.map(privileges, PRIVILEGE_LIST_TYPE));

        return "privilegeTableView";
    }
}
