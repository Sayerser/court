package org.course.service;

import org.course.model.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BestLawyersService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BestLawyersService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Метод для получения адвокатов с рейтингом выше среднего
    public List<Lawyer> getLawyersWithHigherRating() {
        // SQL запрос для получения адвокатов с рейтингом выше среднего
        String sql = "SELECT l.name, l.surname, l.specialization, l.email, r.rating_value " +
                "FROM lawyers l " +
                "JOIN Rating r ON l.Rating_ID = r.ID " +
                "WHERE r.rating_value > (SELECT AVG(rating_value) FROM Rating)";

        // Выполняем запрос и получаем результат в виде списка Map
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);

        // Преобразуем Map в список объектов Lawyer
        return result.stream()
                .map(row -> new Lawyer(
                        (String) row.get("name"),
                        (String) row.get("surname"),
                        (String) row.get("specialization"),
                        (String) row.get("email"),
                        // Здесь проверяем и правильно конвертируем значение в float
                        row.get("rating_value") != null ? ((Number) row.get("rating_value")).floatValue() : 0.0f
                ))
                .collect(Collectors.toList());
    }
}
