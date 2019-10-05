package com.ahasan.udemy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			service.submit(new Works());
		}
	}
}

class Works implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i+":");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
