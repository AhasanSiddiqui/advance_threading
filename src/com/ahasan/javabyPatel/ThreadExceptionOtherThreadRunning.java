package com.ahasan.javabyPatel;

import java.lang.Thread.UncaughtExceptionHandler;
/*Only thread from which the exception is occured will terminate.
Other thread will continue to run and progress if an exception is thrown from one thread. 

Let's see example and understand, */

public class ThreadExceptionOtherThreadRunning {
	public static void main(String[] args) {
		//// Register Global Exception Handler for all Threads
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(
						"Default Exception Handler :Thread Name :" + t.getName() + " Message : " + e.getMessage());
			}
		});
		// //Register ThreadGroup Exception Handler for all Threads in ThreadGroup
		ThreadGroup threadGroup = new ThreadGroup("MyGroup") {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(
						"Default Exception Handler :Thread Name :" + t.getName() + " Message : " + e.getMessage());
			}
		};

		Thread thread1 = new Thread(threadGroup, new WorkerThread());
		thread1.setName("T1");

		thread1.start();

		Thread thread2 = new Thread(threadGroup, new WorkerThread());
		thread2.setName("T2");
		thread2.start();

		Thread thread3 = new Thread(threadGroup, new WorkerThread());
		thread3.setName("T3");
		thread3.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(
						"Thread Exception Handler : Thread Name : " + t.getName() + " Message " + e.getMessage());
			}

		});
		thread3.start();

		Thread thread4 = new Thread(threadGroup, new WorkerThread());
		thread4.setName("T4");
		thread4.start();

		Thread thread5 = new Thread(() -> {
			while (true) {
				try {
					System.out.println("I am printing");
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		thread5.setName("T5");
		thread5.start();

	}
}

class WorkerThread extends Thread {
}

/*
 * In above example, RuntimeException thrown by Thread "t1", "t2", "t3", and
 * "t4" will not affect thread "t5" which prints "I am printing" and it
 * continues to print even after exception is thrown from other threads.
 * 
 * In general, Exception thrown by one thread will not affect another thread, as
 * all threads are independent and have different call stack. So exception from
 * one thread will propagate up untill the handler is not found and if no
 * handler is configured then default "main" ThreadGroup handler will be invoked
 * for that particular thread.
 */