package com.nirmalsprojects.nutrient.app.console.commands;

import java.util.ArrayList;
import java.util.List;

public abstract class Command implements ICommand {
	
	/**
	 * Index of the command name
	 */
	private static final int COMMAND_INDEX = 0;
	
	/**
	 * List of supported sub commands
	 */
	protected ArrayList<ISubCommand> subCommands;
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getSubCommands()
	 */
	public ArrayList<ISubCommand> getSubCommands() {
		return subCommands;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#isCommandParsable(java.util.List)
	 */
	public boolean isCommandParsable(List<String> userInput) {
		return (userInput.get(COMMAND_INDEX).equalsIgnoreCase(getName()));
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#executeCommand(java.util.List)
	 */
	public boolean executeCommand(List<String> userInput) {
		for (ISubCommand subCmd : subCommands) {
			if (subCmd.isCommandParsable(userInput)) {
				return subCmd.executeCommand(userInput);
			}
		}
		return false;
	}

}
