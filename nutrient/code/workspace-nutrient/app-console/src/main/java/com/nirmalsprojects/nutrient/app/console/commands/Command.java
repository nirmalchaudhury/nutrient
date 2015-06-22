package com.nirmalsprojects.nutrient.app.console.commands;

import java.util.ArrayList;
import java.util.List;

public abstract class Command implements ICommand {
	
	private static final int COMMAND_INDEX = 0;
	
	protected ArrayList<ISubCommand> subCommands;
	
	public ArrayList<ISubCommand> getSubCommands() {
		return subCommands;
	}
	
	public boolean isCommandParsable(List<String> userInput) {
		return (userInput.get(COMMAND_INDEX).equalsIgnoreCase(getName()));
	}
	
	public boolean executeCommand(List<String> userInput) {
		for (ISubCommand subCmd : subCommands) {
			if (subCmd.isCommandParsable(userInput)) {
				return subCmd.executeCommand(userInput);
			}
		}
		return false;
	}

}
