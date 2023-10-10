package com.develhope.develhopespringboot.app.weather;


import lombok.Getter;

/**
 * the weather representation.
 * @author kamar baraka.*/

@Getter
public record WeatherDTO(
        long id,
        String main,
        String description,
        String icon
) {
}
