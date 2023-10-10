package com.develhope.develhopespringboot.app.excercise2;

import lombok.Getter;

/**
 * the meal dto to update meal price.
 * @author kamar baraka.*/

@Getter
public record MealPriceDTO(
        double price
) {
}
