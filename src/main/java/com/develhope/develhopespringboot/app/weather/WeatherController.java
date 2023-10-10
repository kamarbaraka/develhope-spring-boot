package com.develhope.develhopespringboot.app.weather;

import com.develhope.develhopespringboot.app.excercise2.Meal;
import com.develhope.develhopespringboot.app.excercise2.MealRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * the weather controller.
 * @author kamar baraka.*/

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"api/weather"})
public class WeatherController {

    private final WeatherAPI weatherAPI;
    private final MealRepository mealRepository;

    /**
     * get winter meals*/
    @GetMapping(value = {"winter-meals"})
    @Operation(method = "GET", summary = "winter meal", description = "get meals fit for winter")
    public ResponseEntity<List<Meal>> getWinterMeals(){

        if (weatherAPI.getWeatherFor(1, 38).equals("Snow"))
            return ResponseEntity.ok(mealRepository.findMealsByDescription("winter"));

        return ResponseEntity.ok(null);
    }
}
