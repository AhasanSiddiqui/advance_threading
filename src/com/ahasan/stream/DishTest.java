package com.ahasan.stream;

import java.util.List;
import java.util.LongSummaryStatistics;

import static java.util.stream.Collectors.*;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.OptionalInt;

public class DishTest {
	public static void main(String[] args) {
		List<Dish> dishes = Dish.getDish();
		OptionalInt max = dishes.stream().mapToInt(Dish::getCalories).max();
		System.out.println(max);
		
		IntSummaryStatistics intSummary = dishes.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println("intSummaryMax : "+intSummary.getMax());
		System.out.println("intSummaryMin : "+intSummary.getMin());
		System.out.println("intSummaryAverage : "+intSummary.getAverage());
		System.out.println("intSummaryCount : "+intSummary.getCount());
		System.out.println("intSummarySum : "+intSummary.getSum());
		
		LongSummaryStatistics longSummary = dishes.stream().collect(summarizingLong(Dish::getCalories));
		System.out.println("longSummaryMax : "+longSummary.getMax());
		System.out.println("longSummaryMin : "+longSummary.getMin());
		System.out.println("longSummaryAverage : "+longSummary.getAverage());
		System.out.println("longSummaryCount : "+longSummary.getCount());
		System.out.println("longSummarySum : "+longSummary.getSum());
		
		DoubleSummaryStatistics doubleSummary = dishes.stream().collect(summarizingDouble(Dish::getCalories));
		System.out.println("doubleSummaryMax : "+doubleSummary.getMax());
		System.out.println("doubleSummaryMin : "+doubleSummary.getMin());
		System.out.println("doubleSummaryAverage : "+doubleSummary.getAverage());
		System.out.println("doubleSummaryCount : "+doubleSummary.getCount());
		System.out.println("doubleSummarySum : "+doubleSummary.getSum());
		
		System.out.println(dishes.stream().map(Dish::getName).collect(joining()));
		
		System.out.println(dishes.stream().map(Dish::getName).collect(joining(",")));
		
		Integer reducingSum = dishes.stream().collect(reducing(0,Dish::getCalories,(c1,c2)->c1+c2));
		Integer reducingSum2 = dishes.stream().collect(reducing(0,Dish::getCalories,Integer::sum));
		
		System.out.println(reducingSum);
		System.out.println(reducingSum2);
	}
}
