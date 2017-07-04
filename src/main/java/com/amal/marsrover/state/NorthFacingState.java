package com.amal.marsrover.state;

public class NorthFacingState extends AbstractMarsRoverState {

	public NorthFacingState() {

	}

	public NorthFacingState(AbstractMarsRoverState prevState) {
		this.xposition = prevState.getXposition();
		this.yposition = prevState.getYposition();
	}

	@Override
	protected AbstractMarsRoverState doLeftTurn() {
		return new WestFacingState(this);
	}

	@Override
	protected AbstractMarsRoverState doRightTurn() {
		return new EastFacingState(this);
	}

	@Override
	public AbstractMarsRoverState advance() {
		yposition = yposition + 1;
		return this;
	}

	@Override
	public void printState() {
		System.out.println(getXposition() + " " + getYposition() + " N");
	}
}
