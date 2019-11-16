package com.peter.kist.controller;

import com.peter.kist.model.dto.PrivilegeDTO;
import com.peter.kist.model.entity.Privilege;
import com.peter.kist.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/privilege")
public class PrivilegeController {

    private final PrivilegeService privilegeService;

    private static final Type PRIVILEGE_LIST_TYPE = (new TypeToken<List<PrivilegeDTO>>(){
    }).getType();

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

        return "privilegeCreation";
    }

    @PostMapping("/create")
    public String createPrivilege(@ModelAttribute("privilegeForm") PrivilegeDTO privilegeForm, BindingResult bindingResult) {

        log.debug("Privilege creation");

        Privilege privilege = mapper.map(privilegeForm, Privilege.class);

        if (bindingResult.hasErrors()) {
            return "privilegeCreation";
        }

        privilegeService.createPrivilege(privilege);

        return "redirect:/privilege/" + privilege.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("privilegeForm") PrivilegeDTO privilege, Model model) {
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

        model.addAttribute("privileges", mapper.map(privileges, PRIVILEGE_LIST_TYPE));

        model.addAttribute("deletedUserName", null);

        return "privilegeTableView";
    }
}
