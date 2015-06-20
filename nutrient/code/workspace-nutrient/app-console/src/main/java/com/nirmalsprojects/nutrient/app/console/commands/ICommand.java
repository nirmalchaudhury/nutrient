package com.nirmalsprojects.nutrient.app.console.commands;

import java.util.List;


public interface ICommand {
	
	String getName();
	
	String getDescription();
	
	List<ISubCommand> getSubCommands();
	
	boolean isCommandParsable(List<String> userInput);
	
	boolean executeCommand(List<String> userInput);
	
}
