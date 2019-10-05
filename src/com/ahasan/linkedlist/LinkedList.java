package com.ahasan.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedList {

	Node head;

	static class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	static int makeAnagram(String a, String b) {
		char[] charArray1 = a.toCharArray();
		char[] charArray2 = b.toCharArray();

		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		int count = 0;

		for (int i = 0; i < charArray1.length; i++) {
			if (charArray1[i] != charArray2[i])
				count = count + 2;
		}
		if (charArray1.length == charArray2.length)
			return count;
		else if (charArray1.length > charArray2.length)
			return count + charArray1.length - charArray2.length;
		else
			return count + charArray2.length - charArray2.length;
	}

	public static void main(String[] args) {

		System.out.println("count : " + makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));

		LinkedList linkedList = new LinkedList();
		/*
		 *
		 * for (int i = 6; i > 0; i--) { linkedList.push(i); }
		 * 
		 * 
		 * System.out.println("Before Duplicate removal list is : ");
		 * linkedList.printList(); linkedList.removeDuplicateHasing();
		 * System.out.println("After Duplicate removal list is : ");
		 * linkedList.printList();
		 */ /*
			 * linkedList.midElementFS();
			 * System.out.println(linkedList.count(linkedList.head, 1));
			 */
		/*
		 * linkedList.head.next.next.next.next.next = linkedList.head;
		 * System.out.println(linkedList.findLoop());
		 * System.out.println("Loop length is : "+linkedList.findLoopLength());
		 */
		/*
		 * linkedList.pairwiseSwap();
		 * 
		 * System.out.println("After PairWise Swap list is : ");
		 * linkedList.pairwiseSwap(); linkedList.printList();
		 */

		/*
		 * System.out.println("After Duplicate removal list is : ");
		 * linkedList.printList(); linkedList.removeDuplicate(); linkedList.printList();
		 */
		/*
		 * linkedList.moveToFront(); linkedList.printList();
		 */

		System.out.println("After reversal : ");
		Node reverce = linkedList.reverce();

		while (reverce != null) {
			System.out.println(reverce.data);
			reverce = reverce.next;
		}

	}

	private Node reverce() {
		Node theCurrent = head;
		Node thePre = null;
		Node theNext = null;
		while (theCurrent != null) {
			theNext = theCurrent.next;
			theCurrent.next = thePre;
			thePre = theCurrent;
			theCurrent = theNext;
		}
		return thePre;
	}

	private void removeDuplicateHasing() {
		Set<Integer> hs = new HashSet<>();
		Node current = head;
		Node prev = null;
		while (current != null) {
			if (hs.contains(current.data))
				prev.next = current.next;
			else {
				hs.add(current.data);
				prev = current;
			}
			current = current.next;
		}

	}

	private void moveToFront() {
		Node theNode = head;
		Node secLast = null;
		while (theNode.next != null) {
			secLast = theNode;
			theNode = theNode.next;
		}
		secLast.next = null;
		theNode.next = head;
		head = theNode;
	}

	private void removeDuplicate() {
		Node theNode = head;
		while (theNode != null) {
			Node theNode2 = theNode.next;
			while (theNode2 != null) {
				if (theNode.data == theNode2.data) {
					theNode = theNode.next;
				}
				theNode2 = theNode2.next;
			}
			theNode = theNode.next;
		}
	}

	private void pairwiseSwap() {
		Node theNode1 = head;
		while (theNode1 != null && theNode1.next != null) {
			int temp = theNode1.data;
			theNode1.data = theNode1.next.data;
			theNode1.next.data = temp;
			theNode1 = theNode1.next.next;
		}
	}

	private boolean findLoop() {
		Node fastPtr = head;
		Node slowPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if (slowPtr == fastPtr)
				return true;
		}
		return false;
	}

	private int findLoopLength() {
		Node fastPtr = head;
		Node slowPtr = head;
		int count = 0;
		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			count++;
			if (slowPtr == fastPtr)
				return count;
		}
		return count;
	}

	private void midElementFS() {
		Node fastPtr = head;
		Node slowPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		System.out.println("Mid Element is : " + slowPtr.data);
	}

	private int count(Node head, int data) {
		return head == null ? 0 : head.data == data ? 1 + count(head.next, data) : count(head.next, data);
	}

	public void push(int theData) {
		Node theNode = new Node(theData);
		theNode.next = head;
		head = theNode;
	}

	private int sizeRecursive(Node theNode) {
		return theNode != null ? 1 + sizeRecursive(theNode.next) : 0;
	}

	private int midElement() {
		Node theNode = head;
		for (int i = 0; i < size() / 2; i++) {
			theNode = theNode.next;
		}
		return theNode.data;
		// return size()%2==0 ? theNode.data:theNode.next.data;
	}

	private int size() {
		Node theNode = head;
		int count = 0;
		while (theNode != null) {
			theNode = theNode.next;
			count++;
		}
		return count;
	}

	private void printList() {
		Node theNode = head;
		while (theNode != null) {
			System.out.println(theNode.data);
			theNode = theNode.next;
		}
	}

	public void addNode(int newData) {
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head + "]";
	}
}
