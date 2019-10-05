package com.ahasan.enums;

import java.util.EnumMap;

public class EnumMapTest {
	
	enum Days {
		SUN,MON,TUES,WED,THU,FRI,SAT
	}
	public static void main(String[] args) {
		EnumMap<Days, String> enumMap=new EnumMap<>(Days.class);
		enumMap.put(Days.SUN,"SUNDAY");
		enumMap.put(Days.MON,"MONDAY");
		enumMap.put(Days.TUES,"TUESDAY");
		enumMap.put(Days.WED,"WEDNESDAY");
		enumMap.put(Days.THU,"THURSDAY");
		enumMap.put(Days.FRI,"FRIDAY");
		enumMap.put(Days.SAT,"SATURDAY");
		System.out.println("Enum Size is : "+enumMap.size());
		System.out.println(enumMap);
		
		enumMap.entrySet().forEach(action->System.out.println(action.getKey()+" : "+action.getValue()));
	}

}
