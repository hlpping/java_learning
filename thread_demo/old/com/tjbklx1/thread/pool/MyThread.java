package com.tjbklx1.thread.pool;

class MyThread extends Thread {
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " MyThread run ...");
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}