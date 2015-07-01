package com.nirmalsprojects.nutrient.module.recipe;

import java.util.ArrayList;

import com.nirmalsprojects.nutrient.dataaccess.types.Ingredient;
import com.nirmalsprojects.nutrient.dataaccess.types.Recipe;

/**
 * Class represents a response to getting a particular recipe given ingredients
 *
 */
public class RecipeResponse {
	
	/**
	 * Recipe
	 */
	public Recipe recipe;
	
	/**
	 * Missing ingredients
	 */
	public ArrayList<Ingredient> missingIngredients;

	public RecipeResponse(Recipe recipe,
			ArrayList<Ingredient> missingIngredients) {
		this.recipe = recipe;
		this.missingIngredients = missingIngredients;
	}

	@Override
	public String toString() {
		return "RecipeResponse [recipe=" + recipe + ", missingIngredients="
				+ missingIngredients + "]";
	}

}
