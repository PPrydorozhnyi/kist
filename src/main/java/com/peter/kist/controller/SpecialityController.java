package com.peter.kist.controller;

import com.peter.kist.model.dto.CafedraDTO;
import com.peter.kist.model.dto.SpecialityDTO;
import com.peter.kist.model.entity.Cafedra;
import com.peter.kist.model.entity.Speciality;
import com.peter.kist.service.CafedraService;
import com.peter.kist.service.SpecialityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.peter.kist.AppConstants.CAFEDRA_LIST_TYPE;
import static com.peter.kist.AppConstants.SPECIALITY_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/speciality")
public class SpecialityController {

    private static final String SPECIALITY_CREATION_PAGE = "specialityCreation";

    private final SpecialityService specialityService;

    private final CafedraService cafedraService;

    private final ConversionService conversionService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getSpeciality(Model model, @PathVariable Integer id) {

        log.debug("getSpeciality");

        Speciality speciality = specialityService.getSpeciality(id);

        model.addAttribute("specialityForm", mapper.map(speciality, SpecialityDTO.class));

        return "specialityView";
    }

    @GetMapping("/create")
    public String createSpeciality(Model model) {

        log.debug("createSpeciality");

        List<Cafedra> cafedras = cafedraService.findAll();

        final Map<String, Object> map = Map.of("specialityForm", new SpecialityDTO(new CafedraDTO()),
                "cafedras", mapper.map(cafedras, CAFEDRA_LIST_TYPE));

        model.addAllAttributes(map);

        return SPECIALITY_CREATION_PAGE;
    }

    @PostMapping("/create")
    public String createSpeciality(@ModelAttribute("specialityForm") SpecialityDTO specialityForm, BindingResult bindingResult) {

        log.debug("Speciality creation");

        Speciality speciality = conversionService.convert(specialityForm, Speciality.class);

        if (bindingResult.hasErrors()) {
            return SPECIALITY_CREATION_PAGE;
        }

        speciality = specialityService.createSpeciality(speciality);

        return "redirect:/speciality/" + speciality.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("specialityForm") SpecialityDTO speciality, Model model) {
        log.debug("editSpeciality");

        List<Cafedra> cafedras = cafedraService.findAll();

        final Map<String, Object> map = Map.of("cafedras", mapper.map(cafedras, CAFEDRA_LIST_TYPE));

        model.addAllAttributes(map);

        return SPECIALITY_CREATION_PAGE;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteSpeciality");

        specialityService.deleteSpeciality(id);

        return "redirect:/speciality/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllSpeciality");

        List<Speciality> specialitys = specialityService.findAll();

        model.addAttribute("specialities", mapper.map(specialitys, SPECIALITY_LIST_TYPE));

        return "specialityTableView";
    }
}
