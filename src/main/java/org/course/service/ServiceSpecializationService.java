package org.course.service;

import org.course.model.ServiceAndSpecialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ServiceSpecializationService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ServiceSpecializationService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ServiceAndSpecialization> getServiceAndSpecializationDetails() {
        String sql = "SELECT l.id AS lawyer_id, l.name AS lawyer_name, l.surname AS lawyer_surname, l.email, " +
                "s.service_name, s.description, s.base_price, " +
                "sc.category_name " +
                "FROM lawyers l " +
                "JOIN services s ON l.id = s.lawyers_id " +
                "JOIN service_category sc ON s.service_category_id = sc.id";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);


        return result.stream()
                .map(row -> new ServiceAndSpecialization(
                        (Integer) row.get("lawyer_id"),                 // id адвоката
                        (String) row.get("lawyer_name"),               // Имя адвоката
                        (String) row.get("lawyer_surname"),            // Фамилия адвоката
                        (String) row.get("email"),                     // Email адвоката
                        (String) row.get("service_name"),              // Название услуги
                        (String) row.get("description"),               // Описание услуги
                        (BigDecimal) row.get("base_price"),            // Базовая стоимость
                        (String) row.get("category_name")              // Категория услуги
                ))
                .collect(Collectors.toList());
    }
}
