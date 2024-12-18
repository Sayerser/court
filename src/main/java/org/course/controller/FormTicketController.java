package org.course.controller;

import org.course.model.FormTicket;
import org.course.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormTicketController {


    private final TicketService ticketService;

    @Autowired
    public FormTicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Эндпоинт для добавления нового тикета
    @PostMapping("submit-ticket")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void addTicket(@RequestBody FormTicket formTicket) {
        ticketService.addTicket(formTicket);  // Вызов метода сервиса для добавления тикета
    }

    @GetMapping("/create-ticket")
    public String show(){
        return "/logic/ticketForm";
    }


}
