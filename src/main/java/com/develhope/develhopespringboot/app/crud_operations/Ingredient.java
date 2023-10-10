package com.develhope.develhopespringboot.app.crud_operations;

import jakarta.persistence.*;
import lombok.Data;

/**
 * entity to hold data on ingredients.
 * @author kamar baraka.*/

@Entity
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String name;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean lactoseFree;
}
