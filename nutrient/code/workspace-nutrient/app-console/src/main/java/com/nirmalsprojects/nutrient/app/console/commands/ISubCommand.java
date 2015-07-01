package com.nirmalsprojects.nutrient.app.console.commands;

import java.util.List;

/**
 * Interface for a subcommand
 */
public interface ISubCommand extends ICommand {
	
	/**
	 * Gets the list of parameters for a sub command
	 * @return sub command parameters
	 */
	List<String> getParameters();

}
