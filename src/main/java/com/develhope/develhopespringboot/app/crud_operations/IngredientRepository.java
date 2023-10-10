package com.develhope.develhopespringboot.app.crud_operations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * the ingredient repository.
 * @author kamar baraka.*/

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Ingredient findIngredientByName(String name);
}
