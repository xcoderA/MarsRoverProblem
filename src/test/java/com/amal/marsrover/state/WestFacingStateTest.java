package com.amal.marsrover.state;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WestFacingStateTest {

	@Test
	public void doLeftTurn_should_return_SouthFacingState() {
		WestFacingState westFacingState = new WestFacingState();
		AbstractMarsRoverState newState = westFacingState.doLeftTurn();
		assertTrue(newState instanceof SouthFacingState);

	}

	@Test
	public void doRightTurn_should_return_NorthFacingState() {
		WestFacingState westFacingState = new WestFacingState();
		AbstractMarsRoverState newState = westFacingState.doRightTurn();
		assertTrue(newState instanceof NorthFacingState);

	}

	@Test
	public void advance_should_decrement_x_y_unchanged() {
		WestFacingState westFacingState = new WestFacingState();
		westFacingState.setXposition(10);
		westFacingState.setYposition(10);
		westFacingState.advance();
		assertEquals(9, westFacingState.getXposition());
		assertEquals(10, westFacingState.getYposition());
	}
}
