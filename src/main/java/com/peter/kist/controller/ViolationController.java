package com.peter.kist.controller;

import com.peter.kist.model.dto.*;
import com.peter.kist.model.entity.*;
import com.peter.kist.service.*;
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

import static com.peter.kist.AppConstants.*;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/violation")
public class ViolationController {

    private static final String VIOLATION_CREATION_PAGE = "violation/violationCreation";

    private static final Type ORDER_SHORT_LIST_TYPE = (new TypeToken<List<OrderShortDTO>>() {
    }).getType();

    private final ViolationService violationService;

    private final PersonService personService;

    private final OrderService orderService;

    private final ViolationKindService violationKindService;

    private final PunishKindService punishKindService;

    private final ConversionService conversionService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getViolation(Model model, @PathVariable Integer id) {

        log.debug("getViolation");

        Violation violation = violationService.getViolation(id);

        model.addAttribute("violationForm", mapper.map(violation, ViolationDTO.class));

        return "violation/violationView";
    }

    @GetMapping("/create")
    public String createViolation(Model model) {

        log.debug("createViolation");

        List<Person> people = personService.findAll();

        List<Order> orders = orderService.findAll();

        List<ViolationKind> violationKinds = violationKindService.findAll();

        List<PunishKind> punishKinds = punishKindService.findAll();

        final Map<String, Object> map = Map.of("violationForm", new ViolationDTO(
                new PersonShortDTO(),
                new OrderShortDTO(),
                new ViolationKindDTO(),
                new PunishKindDTO()),
                "people", mapper.map(people, PERSON_SHORT_LIST_TYPE),
                "orders", mapper.map(orders, ORDER_SHORT_LIST_TYPE),
                "violationKinds", mapper.map(violationKinds, VIOLATION_KIND_LIST_TYPE),
                "punishKinds", mapper.map(punishKinds, PUNISH_KIND_DTO_LIST_TYPE));

        model.addAllAttributes(map);

        return VIOLATION_CREATION_PAGE;
    }

    @PostMapping("/create")
    public String createViolation(@ModelAttribute("violationForm") ViolationDTO violationForm, BindingResult bindingResult) {

        log.debug("Violation creation");

        Violation violation = conversionService.convert(violationForm, Violation.class);

        if (bindingResult.hasErrors()) {
            return VIOLATION_CREATION_PAGE;
        }

        violation = violationService.createViolation(violation);

        return "redirect:/violation/" + violation.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("violationForm") ViolationDTO violation, Model model) {
        log.debug("editViolation");

        List<Person> people = personService.findAll();

        List<Order> orders = orderService.findAll();

        List<ViolationKind> violationKinds = violationKindService.findAll();

        List<PunishKind> punishKinds = punishKindService.findAll();

        final Map<String, Object> map = Map.of("people", mapper.map(people, PERSON_SHORT_LIST_TYPE),
                "orders", mapper.map(orders, ORDER_SHORT_LIST_TYPE),
                "violationKinds", mapper.map(violationKinds, VIOLATION_KIND_LIST_TYPE),
                "punishKinds", mapper.map(punishKinds, PUNISH_KIND_DTO_LIST_TYPE));

        model.addAllAttributes(map);

        return VIOLATION_CREATION_PAGE;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteViolation");

        violationService.deleteViolation(id);

        return "redirect:/violation/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllViolation");

        List<Violation> violations = violationService.findAll();

        model.addAttribute("violations", mapper.map(violations, VIOLATION_LIST_TYPE));

        return "violation/violationTableView";
    }
}


