package com.nirmalsprojects.nutrient.app.console.commands.kitchen;

import java.util.ArrayList;

import com.nirmalsprojects.nutrient.app.console.commands.Command;
import com.nirmalsprojects.nutrient.app.console.commands.ISubCommand;

public class KitchenCmd extends Command {
	
	public static final String CMD_NAME = "-kitchen";
	
	public static final String DESCRIPTION = "Use to modify kitchen items";
	
	public KitchenCmd(ArrayList<ISubCommand> subCommands) {
		this.subCommands = subCommands;
	}
	
	public String getName()	{
		return CMD_NAME;
	}
	
	public String getDescription() {
		return DESCRIPTION;
	}
	
}
