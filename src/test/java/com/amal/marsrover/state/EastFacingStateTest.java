package com.amal.marsrover.state;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EastFacingStateTest {

	@Test
	public void doLeftTurn_should_return_NorthFacingState() {
		EastFacingState eastFacingState = new EastFacingState();
		AbstractMarsRoverState newState = eastFacingState.doLeftTurn();
		assertTrue(newState instanceof NorthFacingState);

	}

	@Test
	public void doRightTurn_should_return_SouthFacingState() {
		EastFacingState eastFacingState = new EastFacingState();
		AbstractMarsRoverState newState = eastFacingState.doRightTurn();
		assertTrue(newState instanceof SouthFacingState);

	}

	@Test
	public void advance_should_increment_x_y_unchanged() {
		EastFacingState eastFacingState = new EastFacingState();
		eastFacingState.setXposition(10);
		eastFacingState.setYposition(10);
		eastFacingState.advance();
		assertEquals(11, eastFacingState.getXposition());
		assertEquals(10, eastFacingState.getYposition());
	}
}
