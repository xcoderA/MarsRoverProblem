package com.amal.marsrover.state;

public class SouthFacingState extends AbstractMarsRoverState {

	public SouthFacingState() {

	}

	public SouthFacingState(AbstractMarsRoverState prevState) {
		this.xposition = prevState.getXposition();
		this.yposition = prevState.getYposition();
	}

	@Override
	protected AbstractMarsRoverState doLeftTurn() {
		return new EastFacingState(this);
	}

	@Override
	protected AbstractMarsRoverState doRightTurn() {
		return new WestFacingState(this);
	}

	@Override
	public AbstractMarsRoverState advance() {
		yposition = yposition - 1;
		return this;
	}

	@Override
	public void printState() {
		System.out.println(getXposition() + " " + getYposition() + " S");
	}
}
