package org.course.service;

import org.course.model.FormTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TicketService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Метод для добавления нового тикета в базу данных
    public void addTicket(FormTicket formTicket) {
        String sql = "INSERT INTO clients (name, surname, email, phone) VALUES (?, ?, ?, ?)";

        // Выполнение запроса на добавление данных
        jdbcTemplate.update(sql, formTicket.getName(), formTicket.getSurname(), formTicket.getEmail(), formTicket.getPhone());
    }
}

