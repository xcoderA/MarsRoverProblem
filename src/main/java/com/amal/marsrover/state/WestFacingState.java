package com.amal.marsrover.state;

public class WestFacingState extends AbstractMarsRoverState {

	public WestFacingState() {

	}

	public WestFacingState(AbstractMarsRoverState prevState) {
		this.xposition = prevState.getXposition();
		this.yposition = prevState.getYposition();
	}

	@Override
	protected AbstractMarsRoverState doLeftTurn() {
		return new SouthFacingState(this);
	}

	@Override
	protected AbstractMarsRoverState doRightTurn() {
		return new NorthFacingState(this);
	}

	@Override
	public AbstractMarsRoverState advance() {
		xposition = xposition - 1;
		return this;
	}

	@Override
	public void printState() {
		System.out.println(getXposition() + " " + getYposition() + " W");
	}
}
