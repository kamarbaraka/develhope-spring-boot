package com.develhope.develhopespringboot.app.excercise2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * the meal repository.
 * @author kamar baraka.*/

@Repository
public interface MealRepository extends JpaRepository<Meal, String > {

    List<Meal> findMealsByDescription(String description);

    List<Meal> findMealsByPriceGreaterThanAndPriceLessThan(double min, double max);
}
