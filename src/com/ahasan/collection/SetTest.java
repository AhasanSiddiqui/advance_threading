package com.ahasan.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.ahasan.bean.Emp;

public class SetTest {
	public static void main(String[] args) {
		Set<Integer> integers = new HashSet<Integer>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		Set<String> strings = new TreeSet<String>();
		strings.add("K");
		System.out.println(strings.add("Z"));
		strings.add("Z");
		strings.add("ZZ");
		strings.add("AA");
		strings.add("XX");
		strings.add("AAA");
		strings.add("BBB");
		Emp e1 = new Emp(1, "A");
		Emp e7 = new Emp(1, "A");
		Emp e2 = new Emp(2, "B");
		Emp e3 = new Emp(3, "C");
		Emp e4 = new Emp(4, "D");
		Emp e5 = new Emp(5, "E");
		Emp e6 = new Emp(6, "F");
		Set<Emp> emps = new HashSet<>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		emps.add(e4);
		emps.add(e5);
		emps.add(e6);
		emps.add(e7);
		Integer integer1=new Integer(10);
		Integer integer2=new Integer(10);
		
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		System.out.println(map.put(integer1, 1));
		System.out.println(map.put(integer2, 1));
		System.out.println("map : "+map);
		
		Map<Integer, Integer> identityMap=new IdentityHashMap<Integer, Integer>();
		
		System.out.println(identityMap.put(integer1, 1));
		System.out.println(identityMap.put(integer2, 1));
		System.out.println("identityMap : "+identityMap);
	}
}
