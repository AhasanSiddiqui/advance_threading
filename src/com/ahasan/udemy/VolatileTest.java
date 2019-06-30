package com.ahasan.udemy;

class Worker implements Runnable {

	private volatile boolean isTerminated = false;

	@Override
	public void run() {
		while (!isTerminated) {
			System.out.println("Hello From Worlker class");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isTerminated() {
		return isTerminated;
	}

	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}

}

public class VolatileTest {
	public static void main(String[] args) {
		Worker worker = new Worker();
		Thread thread=new Thread(worker);
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		worker.setTerminated(true);
		System.out.println("Finished...");
	}
}
