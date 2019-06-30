package com.ahasan.udemy;

import java.util.ArrayList;
import java.util.List;

class Processor {
	private List<Integer> list = new ArrayList<Integer>();
	private static final int LIMIT = 5;
	private static final int BOTTOM = 0;
	private final Object lock = new Object();
	private int value = 0;

	public void producer() throws InterruptedException {
		while (true) {
			synchronized (lock) {
				if (list.size() == LIMIT) {
					System.out.println("Waiting for removing item from the list ...");
					lock.wait();
				} else {
					System.out.println("Adding : " + value);
					list.add(value);
					value++;
					lock.notify();
				}
				Thread.sleep(500);
			}
		}
	}

	public void consumer() throws InterruptedException {

		while (true) {
			synchronized (lock) {
				if (list.size() == BOTTOM) {
					System.out.println("Waiting for adding items to the list ...");
					lock.wait();
				} else {
					System.out.println("Removed : " + list.remove(--value));
					lock.notify();
				}
				Thread.sleep(500);
			}
		}

	}
}

public class ProducerConsumer {
	public static void main(String[] args) {
		Processor processor=new Processor();
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		thread1.start();
		thread2.start();
	}
}
