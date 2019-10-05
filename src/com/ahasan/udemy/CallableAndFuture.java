package com.ahasan.udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service=Executors.newCachedThreadPool();
		List<Future<String>> list = new ArrayList<Future<String>>();
		for (int i = 0; i < 5; i++) {
			Future<String> submit = service.submit(new Proccessor(i+1));
			list.add(submit);
		}
		for (Future<String> future : list) {
			System.out.println(future.get());
		}
		
		service.shutdown();
	}
}

class Proccessor implements Callable<String> {
	private int id;
	
	public Proccessor(int id) {
		super();
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "id : "+id;
	}
}
