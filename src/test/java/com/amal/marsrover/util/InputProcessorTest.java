package com.amal.marsrover.util;

import com.amal.marsrover.MarsRover;

import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.internal.WhiteboxImpl;

import java.io.FileNotFoundException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InputProcessorTest {

	InputProcessor inputProcessor;

	@Before
	public void initialize() throws Exception {
		inputProcessor = new InputProcessor("./src/main/resources/test/MarsRoverTestInputs.txt");
	}

	@Test(expected = FileNotFoundException.class)
	public void should_throw_exception_if_file_not_found() throws Exception {
		InputProcessor errorInputProcessor = new InputProcessor("non_existent_file_name");

	}

	@Test(expected = RuntimeException.class)
	public void should_throw_exception_if_plateau_sizes_in_wrong_format() throws Exception {

		WhiteboxImpl.invokeMethod(inputProcessor, "processPlateauSizes", "12");

	}

	@Test(expected = RuntimeException.class)
	public void buildRover_should_throw_exception_if_rover_position_in_wrong_format() throws Exception {
		WhiteboxImpl.invokeMethod(inputProcessor, "buildRover", "abcd");
	}

	@Test
	public void buildRover_should_return_marsrover_obj_if_input_is_correct() throws Exception {
		Object result = WhiteboxImpl.invokeMethod(inputProcessor, "buildRover", "3 3 N");
		assertThat(result instanceof MarsRover, is(true));
	}

	@Test(expected = RuntimeException.class)
	public void processDirection_should_throw_exception_if_wrong_format() throws Exception {
		WhiteboxImpl.invokeMethod(inputProcessor, "processDirection", "abcd");
	}

	@Test(expected = RuntimeException.class)
	public void validateCommand_should_throw_exception_if_command_not_valid() throws Exception {
		WhiteboxImpl.invokeMethod(inputProcessor, "validateCommand", "LETT");
	}
}
