package org.course.service;

import org.course.model.CaseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CaseService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Метод для получения списка дел с данными о юристах
    public List<CaseDetails> getCaseDetails() {
        String sql = "SELECT cases.ID, cases.case_status, " +
                "lawyers.name AS lawyer_name, lawyers.surname AS lawyer_surname, " +
                "cases.filing_date, cases.closing_date " +
                "FROM cases " +
                "LEFT JOIN lawyers ON cases.lawyers_ID = lawyers.ID";  // SQL запрос

        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);  // Выполнение запроса и получение результатов

        // Преобразование результата в список объектов CaseDetails
        return result.stream()
                .map(row -> new CaseDetails(
                        (Integer) row.get("ID"),
                        (String) row.get("case_status"),
                        (String) row.get("lawyer_name"),  // Изменено, чтобы соответствовать псевдониму SQL
                        (String) row.get("lawyer_surname"), // Изменено, чтобы соответствовать псевдониму SQL
                        (java.sql.Date) row.get("filing_date"),
                        (java.sql.Date) row.get("closing_date")
                ))
                .collect(Collectors.toList());
    }
}
