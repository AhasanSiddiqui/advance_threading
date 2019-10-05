package com.ahasan.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CMExceptionTest {
	public static void main(String[] args) {
		List<Integer> integers=new ArrayList<Integer>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		
		Iterator<Integer> iterator=integers.iterator();
		
		while (iterator.hasNext()) {
			integers.add(1);
			iterator.next();
		}
		System.out.println(integers);
	}
}
