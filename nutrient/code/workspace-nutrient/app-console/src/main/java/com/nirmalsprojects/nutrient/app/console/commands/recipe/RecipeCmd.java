package com.nirmalsprojects.nutrient.app.console.commands.recipe;

import java.util.ArrayList;

import com.nirmalsprojects.nutrient.app.console.commands.Command;
import com.nirmalsprojects.nutrient.app.console.commands.ISubCommand;

/**
 * Recipe Command
 */
public class RecipeCmd extends Command {
	
	/**
	 * Command name
	 */
	public final static String NAME = "-recipe";
	
	/**
	 * Command description
	 */
	public final static String DESCRIPTION = "Create and modify recipes";
	
	/**
	 * Constructors
	 * 
	 * @param subCommands supported subcommands
	 */
	public RecipeCmd(ArrayList<ISubCommand> subCommands) {
		this.subCommands = subCommands;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getName()
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getDescription()
	 */
	public String getDescription() {
		return DESCRIPTION;
	}

}
