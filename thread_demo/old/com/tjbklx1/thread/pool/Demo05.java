package com.tjbklx1.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo05 {
	public static void main(String[] args) {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		Thread t3 = new MyThread();
		Thread t4 = new MyThread();
		Thread t5 = new MyThread();
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.schedule(t4, 10, TimeUnit.MILLISECONDS);
		pool.schedule(t5, 10, TimeUnit.MILLISECONDS);
		pool.shutdown();
	}
}
