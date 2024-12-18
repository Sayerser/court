package org.course.controller;

import org.course.model.ServiceAndSpecialization;
import org.course.service.LawyersService;
import org.course.model.Lawyer;
import org.course.service.ServiceSpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LawyersCardController {

    private final ServiceSpecializationService serviceSpecializationService;

    @Autowired
    public LawyersCardController(ServiceSpecializationService serviceSpecializationService) {
        this.serviceSpecializationService = serviceSpecializationService;
    }

    // Endpoint для получения списка юристов и отображения на странице
    @GetMapping("/services")
    public String getLawyerDetails(Model model) {
        List<ServiceAndSpecialization> lawyers = serviceSpecializationService.getServiceAndSpecializationDetails();
        model.addAttribute("lawyers", lawyers);  // Передаем данные в модель
        return "/logic/lawyersCard";
    }
}

