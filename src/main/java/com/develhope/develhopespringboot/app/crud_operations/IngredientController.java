package com.develhope.develhopespringboot.app.crud_operations;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * the ingredient controller.
 * @author kamar baraka.*/

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"/api/ingredient"})
public class IngredientController {

    private final IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<IngredientDTO> postIngredient(@RequestBody IngredientDTO dto){

        /*persist ingredient*/
        IngredientDTO ingredient = ingredientService.createIngredient(dto);
        /*return the saved ingredient*/
        return ResponseEntity.status(201).body(ingredient);
    }

    @GetMapping
    public ResponseEntity<List<IngredientDTO>> getAllIngredients(){

        /*get all the ingredients*/
        List<IngredientDTO> allIngredients = ingredientService.getAllIngredients();
        /*return all ingredients*/
        return ResponseEntity.ok(allIngredients);
    }
    @GetMapping(value = {"{name}"})
    public ResponseEntity<IngredientDTO> getIngredientByName(@PathVariable("name") String name){

        /*get ingredient by name*/
        IngredientDTO ingredient = ingredientService.getIngredientByName(name);
        /*return the ingredient*/
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping(value = {"{id}"})
    public void updateIngredientById(@PathVariable("id") long id, @RequestBody IngredientDTO dto){

        /*update the ingredient*/
        ingredientService.updateIngredientById(id, dto);
    }
    public void deleteIngredientById(@PathVariable("id") long id){

        /*delete the ingredient*/
        ingredientService.deleteIngredientById(id);
    }
}
