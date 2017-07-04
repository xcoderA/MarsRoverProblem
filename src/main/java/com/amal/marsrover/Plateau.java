package com.amal.marsrover;

public class Plateau {

	private int minx;
	private int maxx;
	private int miny;
	private int maxy;
	private int[][] filledPositions;

	public Plateau(int minx, int miny, int maxx, int maxy) {
		this.minx = minx;
		this.maxx = maxx;
		this.miny = miny;
		this.maxy = maxy;
		filledPositions = new int[maxx + 1][maxy + 1];
	}

	public int getMinx() {
		return minx;
	}

	public int getMaxx() {
		return maxx;
	}

	public int getMiny() {
		return miny;
	}

	public int getMaxy() {
		return maxy;
	}

	public void fillPosition(int x, int y) {
		filledPositions[x][y] = 1;
	}

	public boolean isPositionFilled(int x, int y) {
		return filledPositions[x][y] == 1;
	}
}
