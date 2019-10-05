package com.ahasan.hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringAnagram {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] =scanner.nextInt();
		rotateArray(n, k, arr);
	}

	public static void rotateArray(int n, int k, int[] arr) {
		for (int i = 0; i < k; i++) {
			int temp = arr[n - 1];
			for (int j = n - 1; j > 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[0] = temp;
		}

		for (int j = 0; j < n; j++) {
			System.out.println(arr[j]);
		}
	}

	private static List<String> findSubString(String str) {
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				result.add(str.substring(i, j));
			}
		}

		return result;
	}
}
