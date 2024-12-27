# Christmas-Recipe-Hub
Web Application to provide and view all the recipes for the Christmas Celebrations

Core Features

1. Recipe Display
The application showcases recipes with high-quality images.
Each recipe includes a title, a short description, and an initial rating.
2. Rating Functionality
Users can provide their ratings for recipes by clicking a "Rate" button next to each recipe.
Ratings are updated dynamically using JavaScript, ensuring immediate feedback.

3. Responsive Design
The application is responsive and adjusts seamlessly across devices.


Frontend: The "Christmas Recipe Hub" is a user-friendly web application built using HTML, CSS, and JavaScript. The application serves as a platform for users to discover, share, and rate Christmas-themed recipes.

Backend: The "Christmas Recipe Hub" is set up using Java and MySQL, with a Spring Boot framework to facilitate RESTful APIs. Key features include:
a. Recipe Search: Allows users to search recipes by ingredients.
b. User Ratings: Users can rate recipes, and average ratings are calculated dynamically.
c. Meal Planner: Users can create meal plans by selecting recipes.

APIs used to handle the functionalities:
1. Post the recipes
Endpoint : POST /api/recipes/add
2. Search Recipes by Ingredients
Endpoint: GET GET /api/recipes/search?ingredients=sugar,butter,eggs
3.Rate a Recipe
Endpoint: POST /api/recipes/rate?recipeId=1&rating=5
4. Get Meal Plan
Endpoint: GET /api/meal-planner/plan?recipeIds=1,2
5. Delete Recipe
Endpoint: DELETE /api/recipes/5

INPUT JSON FILE: 
{  
      "Name": "Roast Turkey",  
      "Ingredients":  
        "1 whole turkey (12-14 lbs),2 tablespoons olive oil,Salt,Black pepper,1 onion, quartered,4 cups chicken broth,Herbs (thyme, rosemary, sage)",  
      "Instructions":  
        "Preheat the oven to 325°F (165°C). Pat the turkey dry with paper towels. Rub the turkey inside and out with olive oil, salt, and pepper Stuff the cavity with onion and herbs. Place the turkey on a roasting rack in a roasting pan. Pour chicken broth into the bottom of the pan. Roast for about 3 hours or until the internal temperature reaches 165°F (75°C). Baste periodically and cover with foil if it browns too quickly. Let rest for 20-30 minutes before carving"
    }  

 {  
      "name": "Mashed Potatoes",  
      "ingredients":  
        "potatoes, 1 cup milk, 1/2 cup butter, Salt, Black pepper,garlic, cream, or cheese",
      "instructions":
       "Boil potatoes in salted water until tender, about 20 minutes. Drain and return potatoes to the pot. Add butter, milk, salt, and pepper. Mash until smooth and creamy. Adjust seasoning as needed."  
    }
{  
      "name": "Gingerbread Cookies",  
      "ingredients":  
        "3 cups all-purpose flour, 1 tablespoon ground ginger, 1 tablespoon ground cinnamon, 1 teaspoon baking soda,1/2 teaspoon salt, 1/2 cup unsalted butter, softened, 1 cup brown sugar, 1 egg, 1/2 cup molasses,icing for decoration(optional)",    
      "instructions":   
           "Preheat oven to 350°F (175°C).Mix flour, ginger, cinnamon, baking soda, and salt in a bowl. In another bowl, cream butter and brown sugar, then beat in egg and molasses. Gradually mix dry ingredients into the wet ingredients. Roll out dough and cut into shapes. Bake for 8-10 minutes. Allow to cool before decorating."  
       
    }
{  
      "name": "Eggnog",  
      "ingredients":  
        "4 cups milk,1 cup heavy cream,3/4 cup sugar,6 large egg yolks,1 teaspoon vanilla extract,1 teaspoon ground nutmeg,1/2 cup bourbon (optional)"  
      ,  
      "instructions":  
        "In a saucepan, combine milk, cream, and half the sugar. Heat until hot but not boiling. In a bowl, whisk egg yolks with remaining sugar until fluffy.Slowly whisk hot milk mixture into egg yolks.Return to saucepan and cook over low heat until slightly thickened. Stir in vanilla, nutmeg, and bourbon if using. Chill before serving."  
       
    }  

