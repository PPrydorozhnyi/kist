package com.peter.kist.controller;

import com.peter.kist.model.dto.GroupDTO;
import com.peter.kist.model.dto.SpecialityShortDTO;
import com.peter.kist.model.entity.Group;
import com.peter.kist.model.entity.Speciality;
import com.peter.kist.service.GroupService;
import com.peter.kist.service.SpecialityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import static com.peter.kist.AppConstants.GROUP_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/group")
public class GroupController {

    private static final String GROUP_CREATION_PAGE = "group/groupCreation";

    private static final Type SPECIALITY_SHORT_LIST_TYPE = (new TypeToken<List<SpecialityShortDTO>>(){
    }).getType();

    private final GroupService groupService;

    private final SpecialityService specialityService;

    private final ConversionService conversionService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getGroup(Model model, @PathVariable Integer id) {

        log.debug("getGroup");

        Group group = groupService.getGroup(id);

        model.addAttribute("groupForm", mapper.map(group, GroupDTO.class));

        return "group/groupView";
    }

    @GetMapping("/create")
    public String createGroup(Model model) {

        log.debug("createGroup");

        List<Speciality> specialities = specialityService.findAll();

        final Map<String, Object> map = Map.of("groupForm", new GroupDTO(new SpecialityShortDTO()),
                "specialities", mapper.map(specialities, SPECIALITY_SHORT_LIST_TYPE));

        model.addAllAttributes(map);

        return GROUP_CREATION_PAGE;
    }

    @PostMapping("/create")
    public String createGroup(@ModelAttribute("groupForm") GroupDTO groupForm, BindingResult bindingResult) {

        log.debug("Group creation");

        Group group = conversionService.convert(groupForm, Group.class);

        if (bindingResult.hasErrors()) {
            return GROUP_CREATION_PAGE;
        }

        group = groupService.createGroup(group);

        return "redirect:/group/" + group.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("groupForm") GroupDTO group, Model model) {
        log.debug("editGroup");

        List<Speciality> specialities = specialityService.findAll();

        final Map<String, Object> map = Map.of("specialities", mapper.map(specialities, SPECIALITY_SHORT_LIST_TYPE));

        model.addAllAttributes(map);

        return GROUP_CREATION_PAGE;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteGroup");

        groupService.deleteGroup(id);

        return "redirect:/group/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllGroup");

        List<Group> groups = groupService.findAll();

        model.addAttribute("groups", mapper.map(groups, GROUP_LIST_TYPE));

        return "group/groupTableView";
    }
}
