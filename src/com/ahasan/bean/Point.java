package com.ahasan.bean;

import java.awt.Color;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point))
			return false;
		Point point = (Point) obj;
		return point.x == point.y;
	}

}
class ColorPoint extends Point {
	@SuppressWarnings("unused")
	private final Color color;

	public ColorPoint(int x, int y,Color color) {
		super(x, y);
		this.color=color;
	}
	
}