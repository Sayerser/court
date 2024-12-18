package org.course.service;

import org.course.model.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AvgMinMaxPriceService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AvgMinMaxPriceService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Пример выполнения запроса для получения максимальной, минимальной и средней стоимости услуги
    public Map<String, BigDecimal> getServicePriceStatistics() {
        String sql = "SELECT MAX(s.base_price) AS max_price, " +
                "MIN(s.base_price) AS min_price, " +
                "AVG(s.base_price) AS avg_price " +
                "FROM services s";  // Запрос для получения максимальной, минимальной и средней цены из таблицы Service

        Map<String, Object> result = jdbcTemplate.queryForMap(sql);  // Получаем результат как Map

        // Преобразуем Map в Map с нужными значениями (BigDecimal)
        return Map.of(
                "max_price", result.get("max_price") != null ? (BigDecimal) result.get("max_price") : BigDecimal.ZERO,
                "min_price", result.get("min_price") != null ? (BigDecimal) result.get("min_price") : BigDecimal.ZERO,
                "avg_price", result.get("avg_price") != null ? (BigDecimal) result.get("avg_price") : BigDecimal.ZERO
        );
    }
}
