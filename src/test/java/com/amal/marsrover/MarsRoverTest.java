package com.amal.marsrover;


import com.amal.marsrover.state.EastFacingState;
import com.amal.marsrover.state.NorthFacingState;
import com.amal.marsrover.state.SouthFacingState;
import com.amal.marsrover.state.WestFacingState;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.reflect.internal.WhiteboxImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MarsRoverTest {

	Plateau plateau;

	@Before
	public void initialize() {
		plateau = new Plateau(0, 0, 10, 10);
	}

	@Test
	public void should_set_currentState_to_NorthFacingState_when_input_N() {
		MarsRover marsRover = new MarsRover(plateau, 10, 10, 'N');
		assertThat(marsRover.getCurrentState() instanceof NorthFacingState, is(true));
	}

	@Test
	public void should_set_currentState_to_SouthFacingState_when_input_S() {
		MarsRover marsRover = new MarsRover(plateau, 10, 10, 'S');
		assertThat(marsRover.getCurrentState() instanceof SouthFacingState, is(true));
	}

	@Test
	public void should_set_currentState_to_EastFacingState_when_input_E() {
		MarsRover marsRover = new MarsRover(plateau, 10, 10, 'E');
		assertThat(marsRover.getCurrentState() instanceof EastFacingState, is(true));
	}

	@Test
	public void should_set_currentState_to_WestFacingState_when_input_W() {
		MarsRover marsRover = new MarsRover(plateau, 10, 10, 'W');
		assertThat(marsRover.getCurrentState() instanceof WestFacingState, is(true));
	}

	@Test
	public void test_isWithinPlateau_success_condition() throws Exception {
		MarsRover marsRover = new MarsRover(plateau, 5, 5, 'N');
		boolean result = WhiteboxImpl.invokeMethod(marsRover, "isWithinPlateau");
		assertThat(result, is(true));
	}

	@Test(expected = RuntimeException.class)
	public void test_isWithinPlateau_failure_condition() throws Exception {
		MarsRover marsRover = new MarsRover(plateau, 10, 10, 'N');
		marsRover.move('M');
	}

}
