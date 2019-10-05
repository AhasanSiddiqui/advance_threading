package com.aahsan.predicate;

import java.util.function.Predicate;

public class PredicateJoin {
	public static void main(String[] args) {
		Predicate<Integer> p1=i->i>10;
		Predicate<Integer> p2=i->i%2==0;
		int arr[] = {0,5,10,15,20,25,30};
		System.out.println("Number Greater that 10 are ");
		checkPredicated(p1, arr);
		System.out.println("Number which are Even  ");
		checkPredicated(p2, arr);
		System.out.println("Number Greater that 10 are and even ");
		checkPredicated(p1.and(p2), arr);
		System.out.println("Number less or euals to 10 are ");
		checkPredicated(p1.negate(), arr);
		System.out.println("Number Greater that 10 are or even ");
		checkPredicated(p1.or(p2), arr);
		
		String name[]= {"Kareena","Katreena","Kajol","Aishwariya","Sonam","Sonakshi"};
		Predicate<String> namePredicate=nameOfActress->nameOfActress.startsWith("K");
		
		for (String string : name) {
			if(namePredicate.test(string))
				System.out.println(string);
		}
	}
	
	public static void checkPredicated(Predicate<Integer> predicate,int []arr) {
		for (int i = 0; i < arr.length; i++) {
			if(predicate.test(arr[i]))
				System.out.println("Number is : "+arr[i]);
		}
	}

}
