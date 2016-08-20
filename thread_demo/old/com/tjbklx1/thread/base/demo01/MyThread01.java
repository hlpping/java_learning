package com.tjbklx1.thread.base.demo01;

class MyThread01 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("run: " + i + ", name: " + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}