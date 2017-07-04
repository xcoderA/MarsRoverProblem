package com.amal.marsrover.state;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SouthFacingStateTest {

	@Test
	public void doLeft_should_Return_EastFacingState() {
		SouthFacingState southFacingState = new SouthFacingState();
		AbstractMarsRoverState newState = southFacingState.doLeftTurn();
		assertTrue(newState instanceof EastFacingState);
	}

	@Test
	public void doRight_should_return_WestFacingState() {
		SouthFacingState southFacingState = new SouthFacingState();
		AbstractMarsRoverState newState = southFacingState.doRightTurn();
		assertTrue(newState instanceof WestFacingState);
	}

	@Test
	public void advance_should_decrement_y_x_unchanged() {
		SouthFacingState southFacingState = new SouthFacingState();
		southFacingState.setXposition(10);
		southFacingState.setYposition(10);
		southFacingState.advance();
		assertEquals(10, southFacingState.getXposition());
		assertEquals(9, southFacingState.getYposition());
	}
}
