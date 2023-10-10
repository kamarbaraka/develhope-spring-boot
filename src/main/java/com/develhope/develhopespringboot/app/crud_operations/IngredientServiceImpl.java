package com.develhope.develhopespringboot.app.crud_operations;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * the ingredient implementation.
 * @author kamar baraka.*/

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final ModelMapper mapper;

    /**
     * convert a dto to entity*/
    private Ingredient convertToEntity(IngredientDTO dto){

        /*concert*/
        return mapper.map(dto, Ingredient.class);
    }

    /**
     * convert to DTO*/
    private IngredientDTO convertToDTO(Ingredient ingredient){

        /*convert*/
        return mapper.map(ingredient, IngredientDTO.class);
    }

    @Override
    public IngredientDTO createIngredient(IngredientDTO ingredientDTO) {

        /*covert to entity*/
        Ingredient ingredient = convertToEntity(ingredientDTO);
        /*persist the ingredient*/
        Ingredient saved = ingredientRepository.save(ingredient);
        /*return the saved*/
        return convertToDTO(saved);
    }

    @Override
    public List<IngredientDTO> getAllIngredients() {

        /*get a list of ingredients and convert to DTOs*/
        return ingredientRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    @Override
    public IngredientDTO getIngredientByName(String name) {

        /*get an ingredient by name*/
        Ingredient ingredient = ingredientRepository.findIngredientByName(name);
        /*convert it to DTO and return*/
        return convertToDTO(ingredient);
    }

    @Override
    public void deleteIngredientById(long id) {

        /*delete ingredient*/
        ingredientRepository.deleteById(id);

    }

    @Override
    public void updateIngredientById(long id, IngredientDTO dto) {

        /*check if ingredient exists*/
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow();
        ingredient.setName(dto.getName());
        ingredient.setVegan(dto.isVegan());
        ingredient.setVegetarian(dto.isVegetarian());
        ingredient.setGlutenFree(dto.isGlutenFree());
        ingredient.setLactoseFree(dto.isLactoseFree());
        /*persist*/
        ingredientRepository.save(ingredient);
    }
}
