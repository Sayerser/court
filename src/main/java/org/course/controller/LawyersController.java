package org.course.controller;

import org.course.service.LawyersService;
import org.course.model.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LawyersController {

    private final LawyersService lawyersService;

    @Autowired
    public LawyersController(LawyersService lawyersService) {
        this.lawyersService = lawyersService;
    }

    // Endpoint для получения списка юристов и отображения на странице
    @GetMapping("/lawyers")
    public String getLawyerDetails(Model model) {
        List<Lawyer> lawyers = lawyersService.getLawyerDetails();
        model.addAttribute("lawyers", lawyers);  // Передаем данные в модель
        return "/logic/lawyers";  // Название Thymeleaf шаблона (например, `lawyers.html`)
    }
}
