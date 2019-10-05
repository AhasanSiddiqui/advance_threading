package com.ahasan.fImplementation;

public class Validator {
	private final ValidationStrategy strategy;

	public Validator(ValidationStrategy strategy) {
		this.strategy = strategy;
	}

	public boolean validate(String s) {
		return strategy.execute(s);
	}

	Validator numericValidator = new Validator(new IsNumeric());
	boolean b1 = numericValidator.validate("aaaa");

	static Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
	boolean b2 = numericValidator.validate("bbbb");

	boolean numericValidator2 = new Validator(s -> s.matches("[a-z]")).validate("aaaa");

	boolean lowerCaseValidator2 = new Validator(s -> s.matches("\\d")).validate("bbbb");

}
