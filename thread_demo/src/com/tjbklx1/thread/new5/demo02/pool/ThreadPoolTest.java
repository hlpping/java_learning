package com.tjbklx1.thread.new5.demo02.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	public static void main(String[] args) {
		
		ExecutorService threadPool =Executors.newFixedThreadPool(3);
		for(int i=0;i<10;i++){
			final int task =i;
			threadPool.execute(new Runnable(){
				public void run() {
					for(int j=0;j<10;j++){
						System.out.println(Thread.currentThread().getName() + " is looping "+j+" for task of "+task);
					}
				}});			
		}
		threadPool.shutdown();
		
		
	}
}
