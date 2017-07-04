package com.amal.marsrover;

import com.amal.marsrover.util.InputProcessor;

import java.util.Iterator;
import java.util.Map;

public class MarsRoverController {

	public static void main(String args[]) throws Exception {

		if (args.length == 0) {
			System.out.println("Please specify the name of the input file as an argument to the program");
			System.exit(1);
		}
		InputProcessor inputProcessor = new InputProcessor(args[0]);
		Plateau plateau = inputProcessor.getPlateau();
		boolean error = false;
		Map<MarsRover, String> rovers = inputProcessor.getRovers();
		Iterator<Map.Entry<MarsRover, String>> it = rovers.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<MarsRover, String> entry = it.next();
			MarsRover marsRover = entry.getKey();
			char[] commands = entry.getValue().toCharArray();
			for (int i = 0; i < commands.length; i++) {
				try {
					marsRover.move(commands[i]);
				} catch (Exception e) {
					System.out.println(" Error occurred :" + e.getMessage());
					error = true;
					break;
				}
			}
			if (error) {
				error = !error;
				continue;
			}
			marsRover.printCurrentState();
			plateau.fillPosition(marsRover.getCurrentState().getXposition(), marsRover.getCurrentState().getYposition());
		}
	}
}
