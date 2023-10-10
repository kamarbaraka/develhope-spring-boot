package com.develhope.develhopespringboot.app.excercise2;

import io.swagger.v3.oas.annotations.Operation;
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

    @PostMapping(value = {"meal"})
    @Operation(method = "POST", summary = "post a meal", description = "create a meal")
    public ResponseEntity<Meal> postMeal(@RequestBody Meal meal){

        /*persist the meal*/
        Meal savedMeal = mealRepository.save(meal);
        /*return the saved meal*/
        return ResponseEntity.status(201).body(savedMeal);
    }

    /**
     * update a meal by name*/
    @PutMapping(value = "meal/{name}")
    @Operation(method = "PUT", summary = "put a meal", description = "update a meal by name")
    @ResponseStatus(value = HttpStatus.OK, reason = "meal updated")
    public void updateMealByName(@PathVariable("name") String name,  @RequestBody Meal meal){

        /*check if meal exists*/
        mealRepository.findById(name).orElseThrow();
        /*update the meal*/
        mealRepository.save(meal);
    }

    /**
     * delete meal by name*/
    @DeleteMapping(value = {"meal/{name}"})
    @Operation(method = "DELETE", summary = "delete a meal", description = "delete a meal by name")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteMealByName(@PathVariable("name") String name){

        /*delete the meal*/
        mealRepository.deleteById(name);
    }

    /**
     * update the price*/
    @PutMapping(value = {"meal/{name}/price"})
    @Operation(method = "PUT", summary = "put price", description = "update the price of a meal by name")
    @ResponseStatus(value = HttpStatus.OK)
    public void updatePriceOfMealByName(@PathVariable("name") String name, @RequestBody MealPriceDTO dto){

        /*check for the meal if exists*/
        Meal savedMeal = mealRepository.findById(name).orElseThrow();
        /*update the price*/
        savedMeal.setPrice(dto.getPrice());
    }
}
