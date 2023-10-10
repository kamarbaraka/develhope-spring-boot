package com.develhope.develhopespringboot.app.excercise2;

import com.develhope.develhopespringboot.app.crud_operations.Ingredient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * the meal entity.
 * @author kamar baraka.*/

@Entity
@Getter
@Setter
public class Meal {

    @Id
    @Column(unique = true, nullable = false)
    private String name;
    private double price;
    private String description;
}
