package com.nirmalsprojects.nutrient.app.console.commands;

import java.util.ArrayList;
import java.util.List;


public abstract class SubCommand implements ISubCommand {
	
	protected static final int SUBCOMMAND_INDEX = 1;
	
	public ArrayList<ISubCommand> getSubCommands() {
		return new ArrayList<ISubCommand>();
	}
	
	public boolean isCommandParsable(List<String> userInput) {
		return (userInput.get(SUBCOMMAND_INDEX).equalsIgnoreCase(getName()));
	}
	
}
