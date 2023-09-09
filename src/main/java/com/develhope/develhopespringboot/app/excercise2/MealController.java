package com.develhope.develhopespringboot.app.excercise2;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * the meal controller.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = {"/api/"})
@AllArgsConstructor
public class MealController {

    private final MealRepository mealRepository;

    /*Exercise 1*/
    @GetMapping(value = {"meals"})
    public ResponseEntity<List<Meal>> getAllMeals(){

        return new ResponseEntity<>(mealRepository.findAll(), HttpStatus.OK);
    }

    /*Exercise 2*/
    @GetMapping(value = {"meal/{name}"})
    public ResponseEntity<Meal> getMealByName(@PathVariable("name") String name){

        Optional<Meal> meal = mealRepository.findById(name);
        return meal.map(value ->
                new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() ->
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    /*Exercise 3*/
    @GetMapping(value = {"meal/description-match/{phrase}"})
    public ResponseEntity<List<Meal>> getByMatchingDescription(@PathVariable("phrase") String description){

        return new ResponseEntity<>(mealRepository.findMealsByDescription(description), HttpStatus.OK);
    }

    /*Exercise 4*/
    @GetMapping(value = {"meal/price"})
    public ResponseEntity<List<Meal>> getMealsByPriceRange(@RequestParam("min") double min, @RequestParam("max") double max){

        return new ResponseEntity<>(mealRepository.findMealsByPriceGreaterThanAndPriceLessThan(min, max), HttpStatus.OK);
    }

    /*extra adding meals*/
    @PostMapping(value = {"meals"})
    public ResponseEntity<String > postMeals(@RequestBody List<Meal> meals){

        mealRepository.saveAll(meals);

        return new ResponseEntity<>("added successfully", HttpStatus.OK);
    }
}
