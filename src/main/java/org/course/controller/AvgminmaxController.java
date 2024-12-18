package org.course.controller;

import org.course.service.AvgMinMaxPriceService;
import org.course.model.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
public class AvgminmaxController {

    private final AvgMinMaxPriceService priceService;

    @Autowired
    public AvgminmaxController(AvgMinMaxPriceService priceService) {
        this.priceService = priceService;
    }

    // Метод для отображения страницы с ценами и юристами
    @GetMapping("/avg-price")
    public String getLawyerInfo(Model model) {
        // Получаем статистику по ценам
        Map<String, BigDecimal> priceStatistics = priceService.getServicePriceStatistics();
        // Добавляем данные в модель для передачи в шаблон
        model.addAttribute("priceStatistics", priceStatistics);

        return "/logic/avgminmax";  // Название шаблона Thymeleaf (lawyers-info.html)
    }
}
