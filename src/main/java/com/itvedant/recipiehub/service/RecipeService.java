package com.itvedant.recipiehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.recipiehub.Entity.Recipe;
import com.itvedant.recipiehub.repository.RecipeRepository;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> searchRecipesByIngredients(String ingredients) {
        return recipeRepository.findByIngredientsContaining(ingredients);
    }

    public Recipe rateRecipe(int recipeId, int rating) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RuntimeException("Recipe not found"));
        recipe.addRating(rating);
        return recipeRepository.save(recipe);
    }
    
    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
    
    public void deleteRecipe(int id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
        recipeRepository.delete(recipe);
    }
}
