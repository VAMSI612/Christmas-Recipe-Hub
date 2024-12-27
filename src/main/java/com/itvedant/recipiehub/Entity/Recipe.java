package com.itvedant.recipiehub.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    
    @Lob // Annotation to map to a large object (BLOB or CLOB)
    private String ingredients;

    @Lob
    private String instructions;
    
    @ElementCollection
    private List<Integer> ratings = new ArrayList<>();
    
    public void addRating(int rating) {
        ratings.add(rating);
    }

    // Method to calculate average rating
    public double getAverageRating() {
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

	public Recipe(String name, String ingredients, String instructions, List<Integer> ratings) {
		super();
		this.name = name;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.ratings = ratings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public List<Integer> getRatings() {
		return ratings;
	}

	public void setRatings(List<Integer> ratings) {
		this.ratings = ratings;
	}


}