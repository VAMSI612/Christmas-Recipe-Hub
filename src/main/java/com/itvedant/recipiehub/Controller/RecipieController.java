package com.itvedant.recipiehub.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.recipiehub.Entity.Recipe;
import com.itvedant.recipiehub.service.RecipeService;

@CrossOrigin(origins = "http://localhost:5500")// In case of mentioning Live server
@RestController
@RequestMapping("/api/recipes")
public class RecipieController {

	@Autowired
    private RecipeService recipeService;

	@GetMapping("/search")
    public ResponseEntity<List<Recipe>> searchRecipes(@RequestParam String ingredients) {
        List<Recipe> recipes = recipeService.searchRecipesByIngredients(ingredients);
        if (recipes.isEmpty()) {
            return ResponseEntity.ok(List.of());
        }
        return ResponseEntity.ok(recipes);
    }

    @PostMapping("/rate")
    public ResponseEntity<Recipe> rateRecipe(@RequestParam int recipeId, @RequestParam int rating) {
        return ResponseEntity.ok(recipeService.rateRecipe(recipeId, rating));
    }
    @PostMapping("/add")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.addRecipe(recipe));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteRecipe(@RequestParam int id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok("Recipe deleted successfully");
    }
}
