package com.nirmalsprojects.nutrient.app.console.commands;

import java.util.ArrayList;
import java.util.List;

public class HelpCmd extends Command {
	
	private static final String NAME = "-help";
	
	private static final String DESCRIPTION = "get available commands";
	
	private ArrayList<ICommand> availableCommands;
	
	public HelpCmd(ArrayList<ICommand> cmds) {
		availableCommands = cmds;
	}

	public String getName() {
		return NAME;
	}

	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public ArrayList<ISubCommand> getSubCommands() {
		return new ArrayList<ISubCommand>();
	}

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
	
	private String getFormattedSubCommandParameters(List<String> parameters) {
		String formattedString = "";
		for (String p : parameters) {
			formattedString+="<" + p + ">";
			formattedString+=" ";
		}
		return formattedString;
	}

}
