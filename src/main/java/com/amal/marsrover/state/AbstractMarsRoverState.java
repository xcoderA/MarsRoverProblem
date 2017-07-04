package com.amal.marsrover.state;

public abstract class AbstractMarsRoverState {

	protected int xposition;
	protected int yposition;

	public AbstractMarsRoverState process(char command) {
		switch (command) {
			case 'L':
				return doLeftTurn();
			case 'R':
				return doRightTurn();
			case 'M':
				return advance();
		}
		return this;
	}

	public abstract void printState();

	protected abstract AbstractMarsRoverState doLeftTurn();

	protected abstract AbstractMarsRoverState doRightTurn();

	public abstract AbstractMarsRoverState advance();

	public int getXposition() {
		return xposition;
	}

	public void setXposition(int xposition) {
		this.xposition = xposition;
	}

	public int getYposition() {
		return yposition;
	}

	public void setYposition(int yposition) {
		this.yposition = yposition;
	}
}
