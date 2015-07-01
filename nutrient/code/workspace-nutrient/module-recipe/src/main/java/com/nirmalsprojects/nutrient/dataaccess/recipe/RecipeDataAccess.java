package com.nirmalsprojects.nutrient.dataaccess.recipe;

import java.util.ArrayList;

import com.nirmalsprojects.nutrient.dataaccess.types.Recipe;

/**
 * Class that stores recipes. Recipes are not persisted after application is closed
 */
public class RecipeDataAccess implements IRecipeDataAccess {
	
	/**
	 * List of recipes
	 */
	private ArrayList<Recipe> recipes;
	
	/**
	 * Constructor
	 */
	public RecipeDataAccess() {
		recipes = new ArrayList<Recipe>();
	}

	/**
	 * @see com.nirmalsprojects.nutrient.dataaccess.recipe.IRecipeDataAccess#addRecipe(com.nirmalsprojects.nutrient.dataaccess.types.Recipe)
	 */
	public boolean addRecipe(Recipe recipe) {
		return recipe != null ? recipes.add(recipe) : false;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.dataaccess.recipe.IRecipeDataAccess#getRecipes()
	 */
	public ArrayList<Recipe> getRecipes() {
		return new ArrayList<Recipe>(recipes);
	}

	/**
	 * @see com.nirmalsprojects.nutrient.dataaccess.recipe.IRecipeDataAccess#getRecipe(java.lang.String)
	 */
	public Recipe getRecipe(String recipeName) {
		for (Recipe recipe : recipes) {
			if (recipe.name.equalsIgnoreCase(recipeName)) {
				return recipe;
			}
		}
		return null;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.dataaccess.recipe.IRecipeDataAccess#removeRecipe(java.lang.String)
	 */
	public boolean removeRecipe(String recipeName) {
		boolean recipeFound = false;
		int recipeIndex = 0;
		for (int i=0; i<recipes.size(); i++) {
			if (recipes.get(i).name.equalsIgnoreCase(recipeName)) {
				recipeFound = true;
				recipeIndex = i;
				break;
			}
		}
		if (recipeFound) {
			recipes.remove(recipeIndex);
			return true;
		}
		return false;
	}

}
