package org.course.controller;

import org.course.model.Lawyer;
import org.course.service.BestLawyersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BestLawyersController {

    private final BestLawyersService bestLawyersService;

    @Autowired
    public BestLawyersController(BestLawyersService bestLawyersService) {
        this.bestLawyersService = bestLawyersService;
    }

    // Эндпоинт для получения списка адвокатов с рейтингом выше среднего
    @GetMapping("/best-lawyers")
    public String getLawyersWithHigherRating(Model model) {
        // Вызываем сервис для получения списка адвокатов
        List<Lawyer> bestLawyers = bestLawyersService.getLawyersWithHigherRating();

        // Добавляем список в модель с ключом "lawyers"
        model.addAttribute("lawyers", bestLawyers);

        // Возвращаем имя Thymeleaf шаблона для рендеринга
        return "/logic/BestLawyers";  // Имя шаблона best-lawyers.html
    }
}
