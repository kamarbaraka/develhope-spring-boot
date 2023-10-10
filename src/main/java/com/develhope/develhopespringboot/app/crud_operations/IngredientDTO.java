package com.develhope.develhopespringboot.app.crud_operations;

import lombok.Getter;

/**
 * the ingredient DTO.
 * @author kamar baraka.*/

@Getter
public record IngredientDTO(
        String name,
        boolean vegetarian,
        boolean vegan,
        boolean glutenFree,
        boolean lactoseFree
) {
}
