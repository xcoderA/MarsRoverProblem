package com.amal.marsrover.state;

public class EastFacingState extends AbstractMarsRoverState {

	public EastFacingState() {

	}

	public EastFacingState(AbstractMarsRoverState prevState) {
		this.xposition = prevState.getXposition();
		this.yposition = prevState.getYposition();
	}

	@Override
	protected AbstractMarsRoverState doLeftTurn() {
		return new NorthFacingState(this);
	}

	@Override
	protected AbstractMarsRoverState doRightTurn() {
		return new SouthFacingState(this);
	}

	@Override
	public AbstractMarsRoverState advance() {
		xposition = xposition + 1;
		return this;
	}

	@Override
	public void printState() {
		System.out.println(getXposition() + " " + getYposition() + " E");
	}
}
