package com.nirmalsprojects.nutrient.app.console.commands.kitchen;

import java.util.ArrayList;

import com.nirmalsprojects.nutrient.app.console.commands.Command;
import com.nirmalsprojects.nutrient.app.console.commands.ISubCommand;

/**
 * Kitchen command
 */
public class KitchenCmd extends Command {
	
	/**
	 * Command Name
	 */
	public static final String CMD_NAME = "-kitchen";
	
	/**
	 * Command Description
	 */
	public static final String DESCRIPTION = "Use to modify kitchen items";
	
	/**
	 * Constructor
	 * 
	 * @param subCommands supported subcommands
	 */
	public KitchenCmd(ArrayList<ISubCommand> subCommands) {
		this.subCommands = subCommands;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getName()
	 */
	public String getName()	{
		return CMD_NAME;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getDescription()
	 */
	public String getDescription() {
		return DESCRIPTION;
	}
	
}
