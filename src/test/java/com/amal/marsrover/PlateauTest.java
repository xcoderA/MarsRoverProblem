package com.amal.marsrover;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlateauTest {

	@Test
	public void test_isPosition_filled_success() {
		Plateau plateau = new Plateau(0, 0, 10, 10);
		plateau.fillPosition(5, 5);
		boolean result = plateau.isPositionFilled(5, 5);
		assertThat(result, is(true));
	}

	@Test
	public void test_isPosition_filled_false() {
		Plateau plateau = new Plateau(0, 0, 10, 10);
		plateau.fillPosition(5, 5);
		boolean result = plateau.isPositionFilled(6, 5);
		assertThat(result, is(false));
	}
}
