package com.develhope.develhopespringboot.app.excercise2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * the meal entity.
 * @author kamar baraka.*/

@Entity
@Getter
@Setter
public class Meal {

    @Id
    private String name;
    private double price;
    private String description;
}
