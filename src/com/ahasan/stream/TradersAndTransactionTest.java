package com.ahasan.stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class TradersAndTransactionTest {

	public static void main(String[] args) {
		List<Transaction> transactions = setTransactionValues();
		System.out.println("-------------------------Problem 1----------------------");
		List<Transaction> yearWiseTransaction1 = transactions.stream().filter(y -> y.getYear() == 2011)
				.sorted((y1, y2) -> y2.getYear() - y1.getYear()).collect(toList());

		yearWiseTransaction1
		.forEach(t -> System.out.println("Name : " + t.getTrader().getName() + " Year : " + t.getYear()));

		//Or
		System.out.println("Version Two of problem 1...");
		List<Transaction> yearWiseTransaction2 = transactions.stream().filter(y -> y.getYear() == 2011)
				.sorted(comparing(Transaction::getValue)).collect(toList());

		yearWiseTransaction2
				.forEach(t -> System.out.println("Name : " + t.getTrader().getName() + " Year : " + t.getYear()));
		
		System.out.println("---------------------------Problem 2 Unique City-----------------------");
		List<String> uniqueCity = transactions.stream().map(c -> c.getTrader().getCity()).distinct().collect(toList());

		uniqueCity.forEach(action -> System.out.println(action));

		System.out.println("-------Version 2 of Problem 2 Unique City-----------------------");
		Set<String> uniqueCity2 = transactions.stream().map(c -> c.getTrader().getCity()).collect(toSet());

		uniqueCity2.forEach(action -> System.out.println(action));

		
		System.out.println("------------------------------Problem 3 Traders Name-------------------------");
		List<Trader> tradersName = transactions.stream().filter(c -> c.getTrader().getCity().equals("Cambridge"))
				.map(t -> t.getTrader()).sorted((t1, t2) -> t1.getName().compareTo(t2.getName())).collect(toList());
		tradersName.forEach(action -> System.out.println(action));
		
		System.out.println("------------------------------Version 2 Problem 3 Traders Name-------------------------");
		List<Trader> tradersName2 = transactions.stream().filter(c -> c.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getTrader).sorted(comparing(Trader::getName)).distinct().collect(toList());

		tradersName2.forEach(action -> System.out.println(action));

		System.out.println("------------------------------Problem 4 Traders Name Sorted-------------------------");
		List<String> tradersNameSortedJoin = transactions.stream().map(t -> t.getTrader().getName())
				.sorted((t1, t2) -> t1.compareTo(t2))
				.collect(toList());
		tradersNameSortedJoin.forEach(action -> System.out.println(action));

		System.out.println("-----------Version 2 Problem 4 Traders Name Sorted-------------------------");
		String tradersNameSortedJoin2 = transactions.stream().map(t -> t.getTrader().getName())
				.distinct()
				.sorted()
				.reduce("",(n1,n2)->n1+n2);
		System.out.println(tradersNameSortedJoin2);

		System.out.println("-----------Version 3 Problem 4 Traders Name Sorted-------------------------");
		String tradersNameSortedJoin3 = transactions.stream().map(t -> t.getTrader().getName())
				.distinct()
				.sorted()
				.collect(joining());
		System.out.println(tradersNameSortedJoin3);

		
		System.out.println("-------------------Problem 5 Traders Name with city Milan---------------");
		Optional<Transaction> tradersNameWithCityName = transactions.stream()
				.filter(c -> c.getTrader().getCity().equals("Milan")).findAny();
		System.out.println(tradersNameWithCityName);

		System.out.println("----------Version wProblem 5 Traders Name with city Milan---------------");
		boolean tradersNameWithCityName2 = transactions.stream()
				.anyMatch(c -> c.getTrader().getCity().equals("Milan"));

		
		System.out.println(tradersNameWithCityName2);

		System.out.println("----------Problem 6 Transaction with city is Cambridge-------------------------");

		List<Integer> transactionWithCityIsCambridge = transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).collect(toList());
		transactionWithCityIsCambridge.forEach(action -> System.out.println(action));

		System.out.println("----------Problem 7 Highest Value of Transaction-------------------------");

		Optional<Integer> max = transactions.stream().map(t -> t.getValue()).reduce(Integer::max);
		System.out.println(max);

		System.out.println("----------Version 2 Problem 7 Highest Value of Transaction-------------------------");

		Optional<Integer> max2 = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		System.out.println(max2);
		
		System.out.println("----------Problem 8 Minimum Value of Transaction-------------------------");

		Optional<Integer> min = transactions.stream().map(t -> t.getValue()).reduce(Integer::min);
		System.out.println(min);

		System.out.println("----------Problem 8 Minimum Value of Transaction-------------------------");

		Optional<Integer> min2 = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
		System.out.println(min2);

	}

	private static List<Transaction> setTransactionValues() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		return Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
	}

}
