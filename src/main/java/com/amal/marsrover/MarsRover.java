package com.amal.marsrover;

import com.amal.marsrover.state.AbstractMarsRoverState;
import com.amal.marsrover.state.EastFacingState;
import com.amal.marsrover.state.NorthFacingState;
import com.amal.marsrover.state.SouthFacingState;
import com.amal.marsrover.state.WestFacingState;

public class MarsRover {

	private AbstractMarsRoverState currentState;
	private Plateau plateau;

	public MarsRover(Plateau plateau, int xposition, int yposition, char state) {

		switch (state) {
			case 'N':
				currentState = new NorthFacingState();
				break;
			case 'S':
				currentState = new SouthFacingState();
				break;
			case 'E':
				currentState = new EastFacingState();
				break;
			case 'W':
				currentState = new WestFacingState();
		}
		currentState.setXposition(xposition);
		currentState.setYposition(yposition);
		this.plateau = plateau;
		if (!isWithinPlateau()) {
			throw new RuntimeException("The Rover starting postion is not within the plateau");
		}
	}

	public void move(Character command) {
		currentState = currentState.process(command);
		if (!isWithinPlateau()) {
			throw new RuntimeException("The rover has gone off the plateau");
		}
		if (plateau.isPositionFilled(currentState.getXposition(), currentState.getYposition())) {
			throw new RuntimeException("The Mars rovers have collided at points : X = " +
					currentState.getXposition() + " and  Y =" + currentState.getYposition());
		}
	}

	private boolean isWithinPlateau() {
		return currentState.getXposition() >= plateau.getMinx() && currentState.getXposition() <= plateau.getMaxx() &&
				currentState.getYposition() >= plateau.getMiny() && currentState.getYposition() <= plateau.getMaxy();
	}

	public AbstractMarsRoverState getCurrentState() {
		return currentState;
	}

	public void printCurrentState() {
		currentState.printState();
	}

	public void setCurrentState(AbstractMarsRoverState currentState) {
		this.currentState = currentState;
	}
}
