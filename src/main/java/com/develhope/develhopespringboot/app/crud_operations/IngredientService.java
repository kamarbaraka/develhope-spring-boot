package com.develhope.develhopespringboot.app.crud_operations;

import java.util.List;

/**
 * the ingredient service.
 * @author kamar baraka.*/

public interface IngredientService {

    /**
     * create ingredient*/
    IngredientDTO createIngredient(IngredientDTO ingredientDTO);
    List<IngredientDTO> getAllIngredients();
    IngredientDTO getIngredientByName(String name);
    void deleteIngredientById(long id);
    void updateIngredientById(long id, IngredientDTO dto);

}
