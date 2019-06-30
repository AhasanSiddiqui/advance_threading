package com.ahasan.javabyPatel;

public class JvmExitExample {
	public static void main(String[] args) {
		final Thread mainThread= Thread.currentThread();
		System.out.println("Inside Main Thread : "+mainThread.getName());
		new Thread(()->{
			Thread childThread=Thread.currentThread();
			for (int i = 0; i < 5; i++) {
				System.out.println("Inside Child Thread : "+childThread.getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Check Main Thread is Alive : "+mainThread.isAlive());
		}).start();
		System.out.println("End of Main Thread ");
	}
}
