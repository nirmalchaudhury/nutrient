package com.nirmalsprojects.nutrient.app.console.commands.recipe;

import java.util.Arrays;
import java.util.List;

import com.nirmalsprojects.nutrient.app.console.commands.SubCommand;
import com.nirmalsprojects.nutrient.module.recipe.IRecipeModule;

public class RecipeGetCmd extends SubCommand {

	/**
	 * Add command
	 */
	private static final String ADD_CMD = "get";
	
	/**
	 * Description
	 */
	private static final String DESCRIPTION = "get a recipe";
	
	/**
	 * Parameters
	 */
	private static final String[] params = new String[]{"recipeName"};
	
	/**
	 * Recipe module
	 */
	IRecipeModule module;
	
	/**
	 * Constructor
	 * 
	 * @param Recipe module
	 */
	public RecipeGetCmd(IRecipeModule module) {
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
		return ADD_CMD;
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
			System.out.println(module.getRecipe(userInput.get(++i)));
			return true;
		} catch (Exception e) {
			// parsing error, return false
		}
		return false;
	}

}
