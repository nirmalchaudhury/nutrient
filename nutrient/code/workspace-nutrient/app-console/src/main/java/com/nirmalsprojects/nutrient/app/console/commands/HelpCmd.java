package com.nirmalsprojects.nutrient.app.console.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * Help Command
 */
public class HelpCmd extends Command {
	
	/**
	 * Command Name
	 */
	private static final String NAME = "-help";
	
	/**
	 * Command Description
	 */
	private static final String DESCRIPTION = "get available commands";
	
	/**
	 * Available commands
	 */
	private ArrayList<ICommand> availableCommands;
	
	/**
	 * Constructor
	 * 
	 * @param cmds available commands
	 */
	public HelpCmd(ArrayList<ICommand> cmds) {
		availableCommands = cmds;
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

	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.Command#getSubCommands()
	 */
	@Override
	public ArrayList<ISubCommand> getSubCommands() {
		return new ArrayList<ISubCommand>();
	}

	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.Command#executeCommand(java.util.List)
	 */
	public boolean executeCommand(List<String> userInput) {
		for (ICommand cmd : availableCommands) {
			System.out.println(cmd.getName() + " -- " + cmd.getDescription());
			for (ISubCommand subCommand : cmd.getSubCommands()) {
				System.out.println(" " + subCommand.getName() + "\t"
						+ getFormattedSubCommandParameters(subCommand.getParameters()));
			}
			System.out.println();
		}
		return true;
	}
	
	/**
	 * Formats the supported parameters into a single string
	 * 
	 * @param parameters list of parameters
	 * @return formatted parameters
	 */
	private String getFormattedSubCommandParameters(List<String> parameters) {
		String formattedString = "";
		for (String p : parameters) {
			formattedString+="<" + p + ">";
			formattedString+=" ";
		}
		return formattedString;
	}

}
