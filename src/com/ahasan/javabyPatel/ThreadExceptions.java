package com.ahasan.javabyPatel;

/*"main" thread will continue to run if an exception is thrown from threads that are created within main thread.*/

public class ThreadExceptions {
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				throw new RuntimeException("Thread Exception Example ");
			}
		});
		thread1.start();
		while (true) {
			System.out.println("ThreadDemo.main()");
			Thread.sleep(1000);
		}
	}
}

/*
 * In above example, RuntimeException thrown by Thread "t1" will not affect
 * "main" thread and it continues to print "ThreadDemo.main()"
 * 
 * In general, Exception thrown by one thread will not affect another thread, as
 * all threads are independent and have different stack.
 */