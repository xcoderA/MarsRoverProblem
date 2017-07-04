package com.amal.marsrover.state;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NorthFacingStateTest {

	@Test
	public void doLeftTurn_should_return_WestFacingState() {
		NorthFacingState northFacingState = new NorthFacingState();
		AbstractMarsRoverState newState = northFacingState.doLeftTurn();
		assertTrue(newState instanceof WestFacingState);
	}

	@Test
	public void doRightTurn_should_return_EastFacingState() {
		NorthFacingState northFacingState = new NorthFacingState();
		AbstractMarsRoverState newState = northFacingState.doRightTurn();
		assertTrue(newState instanceof EastFacingState);
	}

	@Test
	public void advance_should_increment_y_x_unchanged() {
		NorthFacingState northFacingState = new NorthFacingState();
		northFacingState.setXposition(10);
		northFacingState.setYposition(10);
		northFacingState.advance();
		assertEquals(10, northFacingState.getXposition());
		assertEquals(11, northFacingState.getYposition());
	}
}
