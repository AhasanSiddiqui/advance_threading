package com.ahasan.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dish {

	public static void main(String[] args) {
		List<Dish> dishs = getDish();
		List<String> result = dishs.stream().filter(d -> {
			System.out.println("Filtering : " + d.getName());
			return d.getCalories() > 150;
		}).map(d -> {
			System.out.println("Mapping : " + d.getName());
			return d.getName();
		}).limit(3).collect(Collectors.toList());
		result.forEach(System.out::println);
	}

	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		super();
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", vegetarian=" + vegetarian + ", calories=" + calories + ", type=" + type + "]";
	}

	public enum Type {
		MEAT, FISH, OTHER
	}

	public static List<Dish> getDish() {
		return Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER), new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER), new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));
	}

}