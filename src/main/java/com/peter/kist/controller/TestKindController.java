package com.peter.kist.controller;

import com.peter.kist.model.dto.TestKindDTO;
import com.peter.kist.model.entity.TestKind;
import com.peter.kist.service.TestKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.peter.kist.AppConstants.TEST_KIND_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/test-kind")
public class TestKindController {

    private final TestKindService testKindService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getTestKind(Model model, @PathVariable Integer id) {

        log.debug("getTestKind");

        TestKind testKind = testKindService.getTestKind(id);

        model.addAttribute("testKindForm", mapper.map(testKind, TestKindDTO.class));

        return "testKindView";
    }

    @GetMapping("/create")
    public String createTestKind(Model model) {

        log.debug("createTestKind");

        model.addAttribute("testKindForm", new TestKindDTO());

        return "testKindCreation";
    }

    @PostMapping("/create")
    public String createTestKind(@ModelAttribute("testKindForm") TestKindDTO testKindForm, BindingResult bindingResult) {

        log.debug("TestKind creation");

        TestKind testKind = mapper.map(testKindForm, TestKind.class);

        if (bindingResult.hasErrors()) {
            return "testKindCreation";
        }

        testKindService.createTestKind(testKind);

        return "redirect:/test-kind/" + testKind.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("testKindForm") TestKindDTO testKind, Model model) {
        log.debug("editTestKind");

        return "testKindCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteTestKind");

        testKindService.deleteTestKind(id);

        return "redirect:/test-kind/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllTestKind");

        List<TestKind> testKinds = testKindService.findAll();

        model.addAttribute("testKinds", mapper.map(testKinds, TEST_KIND_LIST_TYPE));

        model.addAttribute("deletedUserName", null);

        return "testKindTableView";
    }
}
