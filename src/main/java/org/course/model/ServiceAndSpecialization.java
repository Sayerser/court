package org.course.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ServiceAndSpecialization {

    private Integer id;
    private String lawyerName;
    private String lawyerSurname;
    private String email;
    private String serviceName;
    private String description;
    private BigDecimal basePrice;
    private String categoryName;

    // Конструктор
    public ServiceAndSpecialization(Integer id, String lawyerName, String lawyerSurname,
                                    String email, String serviceName, String description,
                                    BigDecimal basePrice, String categoryName) {
        this.id = id;
        this.lawyerName = lawyerName;
        this.lawyerSurname = lawyerSurname;
        this.email = email;
        this.serviceName = serviceName;
        this.description = description;
        this.basePrice = basePrice;
        this.categoryName = categoryName;
    }
}
