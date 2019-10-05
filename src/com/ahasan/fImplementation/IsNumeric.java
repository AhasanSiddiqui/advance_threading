package com.ahasan.fImplementation;

public class IsNumeric implements ValidationStrategy {
	public boolean execute(String s) {
		return s.matches("\\d+");
	}
}