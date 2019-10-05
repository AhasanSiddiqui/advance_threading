package com.ahasan.stream;

public class TestPproblem {
	public static void main(String[] args) {
		int arr[] = {6,1,3,3,3,6,6};
		for (int i = 0; i < arr.length; i++) {
			int index =arr[i]%arr.length;
			arr[index] +=arr.length;
		}
		for (int i = 0; i < arr.length; i++) {
			if((arr[i]/arr.length)==1)
				System.out.println(i);
		}
	}
}
