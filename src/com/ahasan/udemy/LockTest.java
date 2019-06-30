package com.ahasan.udemy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	private static int counter = 0;
	private static Lock lock = new ReentrantLock();

	public static void increment() {
		lock.lock();
		for (int i = 0; i < 10000; i++) {
			counter++;
		}
		lock.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
					increment();
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();
			}
		});
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println("Counter is : " + counter);
	}
}
