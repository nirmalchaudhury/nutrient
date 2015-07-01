package com.nirmalsprojects.nutrient.app.console.commands;

import java.util.List;

/**
 * Interface for app console commands
 */
public interface ICommand {
	
	/**
	 * Returns the name of of the command
	 * 
	 * @return name of the command
	 */
	String getName();
	
	/**
	 * Returns the command description
	 * 
	 * @return command description
	 */
	String getDescription();
	
	/**
	 * Gets the list of sub commands associated with the command
	 * 
	 * @return sub-commands
	 */
	List<ISubCommand> getSubCommands();
	
	/**
	 * Checks if the input command is parsable
	 * 
	 * @param userInput user input command
	 * @return true if the command is parsable, false otherwise
	 */
	boolean isCommandParsable(List<String> userInput);
	
	/**
	 * Executes the command
	 * 
	 * @param userInput user input command
	 * @return returns if the execution was successfully, false otherwise
	 */
	boolean executeCommand(List<String> userInput);
	
}
