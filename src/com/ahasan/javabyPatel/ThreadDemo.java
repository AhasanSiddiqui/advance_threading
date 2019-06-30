package com.ahasan.javabyPatel;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ThreadTask implements Callable<Result> {

	@Override
	public Result call() throws Exception {
		Result result = new Result();
		result.code = 200;
		result.message = "SUCCESS";
		return result;
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<Result> resultObject = executorService.submit(new ThreadTask());
		Result result=null;
		
		try {
			result=resultObject.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(result.code+" : "+result.message);
		executorService.shutdown();
	}
}

class Result {
	public int code;
	public String message;
}