package com.nirmalsprojects.nutrient.app.console.commands.recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.nirmalsprojects.nutrient.app.console.commands.SubCommand;
import com.nirmalsprojects.nutrient.module.recipe.IRecipeModule;
import com.nirmalsprojects.nutrient.module.recipe.RecipeResponse;

public class RecipeIngredientCmd extends SubCommand {

	/**
	 * get command
	 */
	private static final String GET_CMD = "ingredient";
	
	/**
	 * Description
	 */
	private static final String DESCRIPTION = "get recipes with desired ingredients";
	
	/**
	 * Parameters
	 */
	private static final String[] params = new String[]{"ingredients (command seperated)"};
	
	/**
	 * Recipe module
	 */
	IRecipeModule module;
	
	/**
	 * Constructor
	 * 
	 * @param Recipe module
	 */
	public RecipeIngredientCmd(IRecipeModule module) {
		this.module = module;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ISubCommand#getParameters()
	 */
	public List<String> getParameters() {
		return Arrays.asList(params);
	}

	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getName()
	 */
	public String getName() {
		return GET_CMD;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getDescription()
	 */
	public String getDescription() {
		return DESCRIPTION;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#executeCommand(java.util.List)
	 */
	public boolean executeCommand(List<String> userInput) {
		if (!isCommandParsable(userInput)) {
			return false;
		}
		try {
			int i = SUBCOMMAND_INDEX;
			String[] ingredients = userInput.get(++i).split(",");
			ArrayList<RecipeResponse> recipes = module.getRecipes(new ArrayList<String>(Arrays.asList(ingredients)));
			System.out.println(recipes);
			return true;
		} catch (Exception e) {
			// parsing error, return false
		}
		return false;
	}

}
