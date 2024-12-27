const apiBaseURL = "http://localhost:8080/api/recipes";

// Fetch recipes based on ingredients
async function fetchRecipes() {
  const ingredients = document.getElementById("ingredients").value;
  const container = document.getElementById("recipe-container");
  container.innerHTML = "";

  if (!ingredients) {
    container.innerHTML = "<p>Please enter ingredients to search for recipes.</p>";
    return;
  }

  try {
    const response = await fetch(`${apiBaseURL}/search?ingredients=${encodeURIComponent(ingredients)}`);
    const data = await response.json();

    if (data.length === 0) {
      container.innerHTML = "<p>No recipes found for the given ingredients.</p>";
      return;
    }

    data.forEach(recipe => {
      const recipeDiv = document.createElement("div");
      recipeDiv.classList.add("recipe");
      recipeDiv.innerHTML = `
        <h3>${recipe.name}</h3>
        <p><strong>Ingredients:</strong> ${recipe.ingredients}</p>
        <p><strong>Instructions:</strong> ${recipe.instructions}</p>
        <button onclick="rateRecipe(${recipe.id})">Rate Recipe</button>
        <button onclick="deleteRecipe(${recipe.id})">Delete Recipe</button>
      `;
      container.appendChild(recipeDiv);
    });
  } catch (error) {
    console.error("Error fetching recipes:", error);
    container.innerHTML = "<p>Something went wrong. Please try again later.</p>";
  }
}

// Add a new recipe
async function addRecipe(event) {
  event.preventDefault();

  const name = document.getElementById("recipe-name").value;
  const ingredients = document.getElementById("recipe-ingredients").value;
  const instructions = document.getElementById("recipe-instructions").value;

  const newRecipe = { name, ingredients, instructions };

  try {
    const response = await fetch(`${apiBaseURL}/add`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(newRecipe)
    });

    if (response.ok) {
      alert("Recipe added successfully!");
      document.getElementById("add-recipe-form").reset();
    } else {
      alert("Failed to add recipe. Please try again.");
    }
  } catch (error) {
    console.error("Error adding recipe:", error);
    alert("An error occurred while adding the recipe.");
  }
}

// Rate a recipe
async function rateRecipe(recipeId) {
  const rating = prompt("Enter your rating (1-5):");

  if (!rating || isNaN(rating) || rating < 1 || rating > 5) {
    alert("Please enter a valid rating between 1 and 5.");
    return;
  }

  try {
    const response = await fetch(`${apiBaseURL}/rate?recipeId=${recipeId}&rating=${rating}`, {
      method: "POST"
    });

    if (response.ok) {
      alert("Thank you for rating the recipe!");
    } else {
      alert("Failed to rate the recipe. Please try again.");
    }
  } catch (error) {
    console.error("Error rating recipe:", error);
    alert("An error occurred while rating the recipe.");
  }
}

// Delete a recipe
async function deleteRecipe(recipeId) {
  if (!confirm("Are you sure you want to delete this recipe?")) return;

  try {
    const response = await fetch(`${apiBaseURL}/${recipeId}`, {
      method: "DELETE"
    });

    if (response.ok) {
      alert("Recipe deleted successfully!");
      fetchRecipes(); // Refresh the recipe list
    } else {
      alert("Failed to delete the recipe. Please try again.");
    }
  } catch (error) {
    console.error("Error deleting recipe:", error);
    alert("An error occurred while deleting the recipe.");
  }
}
