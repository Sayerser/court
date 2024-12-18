package org.course.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lawyer {

    private String name;
    private String surname;
    private String specialization;
    private String email;
    private float ratingValue;

    // Конструктор, геттеры и сеттеры

    public Lawyer(String name, String surname, String specialization, String email, float ratingValue) {
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
        this.email = email;
        this.ratingValue = ratingValue;
    }

}

