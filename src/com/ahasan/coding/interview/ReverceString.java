package com.ahasan.coding.interview;

public class ReverceString {
	public static void main(String[] args) {
		reverceStringBuilderApproch("ahasan");
		reverce("ahasan");
		System.out.println("checkArmstrong : "+checkArmstrong(153));
		System.out.println("numberPalindrome : "+numberPalindrome(10011));
	}

	private static boolean numberPalindrome(int i) {

		int num =i;
		int rev=0;
		while (num!=0) {
			rev=rev*10+num%10;
			num/=10;
		}
		return rev==i?true:false;
	}

	private static boolean checkArmstrong(int i) {
		int arm=0;
		int num=i;
		while(num!=0) {
			arm+=(num%10)*(num%10)*(num%10);
			num=num/10;
		}
		return arm==i?true:false;
	}

	private static void reverce(String string) {
		
		String reverce= "";
		
		for (int i = 0; i < string.length(); i++) {
			reverce+=string.charAt(string.length()-i-1);
		}
		System.out.println(reverce);
	}

	private static void reverceStringBuilderApproch(String string) {
		System.out.println(new StringBuilder(string).reverse());
		
	}
}
