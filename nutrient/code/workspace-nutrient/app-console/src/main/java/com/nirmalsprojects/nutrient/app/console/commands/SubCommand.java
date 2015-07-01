package com.nirmalsprojects.nutrient.app.console.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract subcommand implementation

 */
public abstract class SubCommand implements ISubCommand {
	
	/**
	 * Index of the sub command
	 */
	protected static final int SUBCOMMAND_INDEX = 1;
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getSubCommands()
	 */
	public ArrayList<ISubCommand> getSubCommands() {
		return new ArrayList<ISubCommand>();
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#isCommandParsable(java.util.List)
	 */
	public boolean isCommandParsable(List<String> userInput) {
		return (userInput.get(SUBCOMMAND_INDEX).equalsIgnoreCase(getName()));
	}
	
}
