package org.course.service;

import org.course.model.Lawyer;  // Импорт модели Lawyer
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LawyersService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LawyersService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Пример выполнения запроса с использованием Rating_ID для получения информации о рейтинге адвоката
    public List<Lawyer> getLawyerDetails() {
        String sql = "SELECT l.name, l.surname, l.specialization, l.email, " +
                "(SELECT r.rating_value FROM Rating r WHERE r.id = l.Rating_ID) AS rating_value " +
                "FROM lawyers l";  // Используем подзапрос для получения rating_value по rating_id из таблицы Rating

        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);  // Получаем список строк в виде Map

        // Преобразуем Map в список объектов Lawyer
        return result.stream()
                .map(row -> new Lawyer(
                        (String) row.get("name"),
                        (String) row.get("surname"),
                        (String) row.get("specialization"),
                        (String) row.get("email"),
                        // Проверка на null для rating_value
                        row.get("rating_value") != null ? (float) row.get("rating_value") : 0.0f // Если rating_value null, ставим 0.0f
                ))
                .collect(Collectors.toList());
    }
}
