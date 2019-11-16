package com.peter.kist.controller;

import com.peter.kist.model.entity.TestKind;
import com.peter.kist.service.TestKindService;
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
@RequestMapping("/test-kind")
public class TestKindController {

    private final TestKindService testKindService;

    @GetMapping("/{id}")
    public String getTestKind(Model model, @PathVariable Integer id) {

        log.debug("getTestKind");

        TestKind testKind = testKindService.getTestKind(id);

        model.addAttribute("testKindForm", testKind);

        return "testKindView";
    }

    @GetMapping("/create")
    public String createTestKind(Model model) {

        log.debug("createTestKind");

        TestKind testKind = new TestKind();

        model.addAttribute("testKindForm", testKind);

        return "testKindCreation";
    }

    @PostMapping("/create")
    public String createTestKind(@ModelAttribute("testKindForm") TestKind testKindForm, BindingResult bindingResult) {

        log.debug("TestKind creation");

        if (bindingResult.hasErrors()) {
            return "testKindCreation";
        }

        testKindService.createTestKind(testKindForm);

        return "redirect:/test-kind/" + testKindForm.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("testKindForm") TestKind testKind, Model model) {
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

        model.addAttribute("testKinds", testKinds);

        model.addAttribute("deletedUserName", null);

        return "testKindTableView";
    }
}
