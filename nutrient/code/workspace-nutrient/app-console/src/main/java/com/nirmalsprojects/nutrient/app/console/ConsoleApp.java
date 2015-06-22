package com.nirmalsprojects.nutrient.app.console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nirmalsprojects.nutrient.app.console.commands.ICommand;

public class ConsoleApp {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");

		@SuppressWarnings("unchecked")
		ArrayList<ICommand> commands = (ArrayList<ICommand>) context.getBean("commands");

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Command (enter '-help' for the list of available commands) : ");

		while (true) {
			boolean commandAvailable = false;
			String[] input = scanner.nextLine().split(" ");
			List<String> inputList = Arrays.asList(input);
			for (ICommand cmd : commands) {
				if (cmd.isCommandParsable(inputList)) {
					commandAvailable = true;
					if (!cmd.executeCommand(inputList)) {
						System.out.println("ERROR - Unable to excute subcommand.");
					}
				}
			}
			if (!commandAvailable) {
				System.out.println("ERROR - Unsupported Command");
			}
		}

	}

}
