package com.ahasan.udemy;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Workerr { 
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void producer() throws InterruptedException {
		lock.lock();
		System.out.println("Producer Method...");
		condition.await();
		System.out.println("Producer Again...");
		lock.unlock();
	}

	public void consumer() throws InterruptedException {
		lock.lock();
		Thread.sleep(2000);
		System.out.println("Consumer method...");
		condition.signal();
		lock.unlock();
	}
}

public class ProducerConsumerWithLock {

	public static void main(String[] args) throws InterruptedException {
		Workerr worker = new Workerr();
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					worker.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					worker.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
	}
}
