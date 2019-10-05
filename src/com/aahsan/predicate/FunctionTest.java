package com.aahsan.predicate;

import java.util.function.Function;

public class FunctionTest {
	public static void main(String[] args) {
		String statement="  my name is ahasan siddiqui   ";
		Function<String, String> result=st->st.trim();
		System.out.println(result.apply(statement));
	}

}
