package com.amal.marsrover.util;

import com.amal.marsrover.MarsRover;
import com.amal.marsrover.Plateau;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class InputProcessor {

	private Plateau plateau;
	private Map<MarsRover, String> rovers = new HashMap<MarsRover, String>();

	public InputProcessor(String filePath) throws Exception {
		try (FileReader fr = new FileReader(filePath);
			 BufferedReader br = new BufferedReader(fr)) {
			String line;
			String plateauSizes = br.readLine();
			if (plateauSizes == null || StringUtils.isEmpty(plateauSizes)) {
				throw new RuntimeException("Not able to read the plateau sizes");
			}
			processPlateauSizes(plateauSizes);
			while ((line = br.readLine()) != null) {
				if (StringUtils.isEmpty(line)) {
					break;
				}
				MarsRover r = buildRover(line);
				line = br.readLine();
				if (line == null || StringUtils.isEmpty(line)) {
					break;
				}
				String command = validateCommand(line);
				rovers.put(r, command);
			}
		}
	}

	private void processPlateauSizes(String plateauSizes) {
		String[] sarray = StringUtils.split(plateauSizes.trim());
		if (sarray.length != 2) {
			throw new RuntimeException("The plateau sizes are not given correctly : " + plateauSizes);
		}
		int x = Integer.parseInt(sarray[0]);
		int y = Integer.parseInt(sarray[1]);
		if (x <= 0 || y <= 0) {
			throw new RuntimeException("The plateau coordinates should be greater than 0: " + plateauSizes);
		}
		plateau = new Plateau(0, 0, x, y);
	}

	private MarsRover buildRover(String roverposition) {

		String[] roverCorordinates = StringUtils.split(roverposition.trim());
		if (roverCorordinates.length != 3) {
			throw new RuntimeException("The rover roverCoordinates are not given correctly : " + roverposition);
		}
		return new MarsRover(plateau, Integer.parseInt(roverCorordinates[0]), Integer.parseInt(roverCorordinates[1]), processDirection(roverCorordinates[2]));

	}

	private char processDirection(String s) {
		if (s.length() != 1) {
			throw new RuntimeException("The Direction of the rover is not given correctly : " + s);
		}
		if (!(s.equals("N") || s.equals("S") || s.equals("E") || s.equals("W"))) {
			throw new RuntimeException("The Direction of the rover is not given correctly direction = " + s);

		}
		return s.charAt(0);
	}

	private String validateCommand(String command) {
		if (!StringUtils.containsOnly(command.trim(), 'L', 'R', 'M')) {
			throw new RuntimeException("The command contains unknown characters : command = " + command);
		}
		return command.trim();
	}

	public Map<MarsRover, String> getRovers() {
		return rovers;
	}

	public Plateau getPlateau() {
		return plateau;
	}
}
