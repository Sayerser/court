package org.course.controller;

import org.course.model.CaseDetails;
import org.course.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CaseController {

    private final CaseService caseService;

    @Autowired
    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    // Endpoint для получения списка юристов и отображения на странице
    @GetMapping("/case-details")
    public String getLawyerDetails(Model model) {
        List<CaseDetails> caseDetails = caseService.getCaseDetails();
        model.addAttribute("caseDetails", caseDetails);  // Передаем данные в модель
        return "/logic/lawyersDeals";  // Название Thymeleaf шаблона (например, `lawyers.html`)
    }
}

