package com.itvedant.recipiehub.Controller;

import java.util.List;

import com.itvedant.recipiehub.Entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meal-planner")
public class MealPlannerController {
    @Autowired
    private JpaRepository recipeRepository;

    @GetMapping("/plan")
    public ResponseEntity<List<Recipe>> getMealPlan(@RequestParam List<Integer> recipeIds) {
        return ResponseEntity.ok(recipeRepository.findAllById(recipeIds));
    }
}
