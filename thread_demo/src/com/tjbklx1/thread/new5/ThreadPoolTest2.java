package com.tjbklx1.thread.new5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest2 {
	public static void main(String[] args) {
		
//		ExecutorService threadPool =Executors.newCachedThreadPool();
		ExecutorService threadPool =Executors.newSingleThreadExecutor();
		for(int i=0;i<10;i++){
			final int task =i;
			threadPool.execute(new Runnable(){
				public void run() {
					for(int j=0;j<10;j++){
						System.out.println(Thread.currentThread().getName()
								+" is looping "+j+" for task of "+task);
					}
				}});			
		}
//		threadPool.shutdown();
		
//		Executors.newScheduledThreadPool(3).schedule(new Runnable(){
//			public void run() {
//				System.out.println("bombing");
//			}}, 10, TimeUnit.SECONDS);
		
		Executors.newScheduledThreadPool(3).scheduleWithFixedDelay(new Runnable(){
			public void run() {
				System.out.println("bombing");
			}}, 10,2, TimeUnit.SECONDS);
	}
}
