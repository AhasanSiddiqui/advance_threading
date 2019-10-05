package com.ahasan.stream;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ahasan.stream.Dish.Type;

import static java.util.stream.Collectors.*;

import java.util.Comparator;

public class DishGroupingTest {

	public static void main(String[] args) {
		List<Dish> dishes = Dish.getDish();

		Map<Type, List<Dish>> groupByType = dishes.stream().collect(groupingBy(Dish::getType));
		System.out.println(groupByType);

		Map<Type, Long> counting = dishes.stream().collect(groupingBy(Dish::getType, counting()));
		System.out.println(counting);

		Map<Type, Optional<Dish>> mostCaloriesByType = dishes.stream()
				.collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
		
		mostCaloriesByType.values().forEach(a->System.out.println(a.get()));
	}

}
