//package com.nirmalsprojects.nutrient.app.console;
//package com.nirmalsprojects.nutrient.app.console;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import org.apache.commons.cli.CommandLine;
//import org.apache.commons.cli.CommandLineParser;
//import org.apache.commons.cli.DefaultParser;
//import org.apache.commons.cli.HelpFormatter;
//import org.apache.commons.cli.Option;
//import org.apache.commons.cli.Options;
//import org.apache.commons.cli.ParseException;
//
//import com.nirmalsprojects.nutrient.app.console.commands.ICommand;
//import com.nirmalsprojects.nutrient.app.console.commands.ISubCommand;
//import com.nirmalsprojects.nutrient.app.console.commands.cart.CartAddCmd;
//import com.nirmalsprojects.nutrient.app.console.commands.cart.CartCmd;
//import com.nirmalsprojects.nutrient.app.console.commands.cart.CartGetCmd;
//import com.nirmalsprojects.nutrient.app.console.commands.cart.CartRemoveCmd;
//import com.nirmalsprojects.nutrient.app.console.commands.kitchen.KitchenCmd;
//import com.nirmalsprojects.nutrient.app.console.commands.kitchen.KitchenGetCmd;
//import com.nirmalsprojects.nutrient.dataaccess.kitchen.IKitchenDataAccess;
//import com.nirmalsprojects.nutrient.dataaccess.kitchen.KitchenDataAccess;
//import com.nirmalsprojects.nutrient.dataaccess.shoppingcart.IShoppingCartDataAccess;
//import com.nirmalsprojects.nutrient.dataaccess.shoppingcart.ShoppingCartDataAccess;
//import com.nirmalsprojects.nutrient.module.common.IModule;
//import com.nirmalsprojects.nutrient.module.common.Modules;
//import com.nirmalsprojects.nutrient.module.kitchen.IKitchenModule;
//import com.nirmalsprojects.nutrient.module.kitchen.KitchenModule;
//import com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule;
//import com.nirmalsprojects.nutrient.module.shoppingcart.ShoppingCartModule;
//
//public class ConsoleApp {
//
//	public static void main(String[] args) {
//
//		IShoppingCartDataAccess shoppingCartDataAccess = new ShoppingCartDataAccess();
//		IShoppingCartModule shoppingCartModule = new ShoppingCartModule(shoppingCartDataAccess);
//		
//		IKitchenDataAccess kitchenDataAccess = new KitchenDataAccess();
//		IKitchenModule kitchenModule = new KitchenModule(kitchenDataAccess);
//		
//		IItemDataAccess itemDataAccess = new ItemDataAccess();
//		IItemModule itemModule = new ItemModule(itemDataAccess);
//		
//		ArrayList<IModule> moduleList = new ArrayList<IModule>();
//		moduleList.add((IModule) shoppingCartModule);
//		moduleList.add((IModule) kitchenModule);
//		moduleList.add((IModule) itemModule);
//		
//		Modules modules = new Modules(moduleList);
//		ModuleListeners listeners = new ModuleListeners(modules);
//		listeners.registerListeners();
//		
//		shoppingCartModule.addItem("Apple", 2);
//		shoppingCartModule.addItem("Orange", 2);
////		
////		shoppingCartModule.removeItem("Apple", 2, true);
////		System.out.println("Shopping Cart: " + shoppingCartModule.getItems().toString());
////		System.out.println("kitchen: " + kitchenModule.getItems().toString());
////		
////		shoppingCartModule.removeItem("Orange", 2, false);
////		System.out.println("Shopping Cart: " + shoppingCartModule.getItems().toString());
////		System.out.println("kitchen: " + kitchenModule.getItems().toString());
//		
//		
//		Options options = new Options();
//		
//		// Shopping Cart Command
//		ArrayList<ISubCommand> cartSubCommands = new ArrayList<ISubCommand>();
//		cartSubCommands.add(new CartAddCmd(shoppingCartModule));
//		cartSubCommands.add(new CartRemoveCmd(shoppingCartModule));
//		cartSubCommands.add(new CartGetCmd(shoppingCartModule));
//		CartCmd cartCmd = new CartCmd(cartSubCommands);
//		Option cartOption = Option.builder(CartCmd.CMD_NAME)
//				.hasArgs()
//				.argName(cartCmd.getSupportedCommands() + "> <args")
//				.desc(CartCmd.DESCRIPTION)
//				.build();
//		options.addOption(cartOption);
//		
//		// Kitchen Command
//		ArrayList<ISubCommand> kitchenSubCommands = new ArrayList<ISubCommand>();
//		kitchenSubCommands.add(new KitchenGetCmd(kitchenModule));
//		KitchenCmd kitchenCmd = new KitchenCmd(kitchenSubCommands);
//		Option kitchenOption = Option.builder(KitchenCmd.CMD_NAME)
//				.hasArgs()
//				.argName(kitchenCmd.getSupportedCommands() + "> <args")
//				.desc(KitchenCmd.DESCRIPTION)
//				.build();
//		options.addOption(kitchenOption);
//		
//		ArrayList<ICommand> commands = new ArrayList<ICommand>();
//		
//		commands.add(cartCmd);
//		commands.add(kitchenCmd);
//		
//		// Console App
//		HelpFormatter formatter = new HelpFormatter();
//		formatter.printHelp("nutrient", options);
//		Scanner scanner = new Scanner(System.in);
//	    
//	    while(true) {
//	    	String input = scanner.nextLine();
//	    	String[] inputArray = input.split(" ");
//			
//			CommandLineParser parser = new DefaultParser();
//			try {
//				CommandLine line = parser.parse(options, inputArray);
//				for (ICommand cmd : commands) {
//					if (line.hasOption(cmd.getName())) {
//						cmd.executeCommand(line.getOptionValues(cmd.getName()));
//					}
//				}
//			} catch (ParseException e) {
//				System.out.println(e.getMessage());
//			}
//		}
//	}
//
//}
