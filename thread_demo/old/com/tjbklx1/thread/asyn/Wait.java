package com.tjbklx1.thread.asyn;
/*
 * Java线程实现异步消息 
 */
import java.util.concurrent.TimeUnit;

class MyObject implements Runnable {
	private Monitor monitor;

	public MyObject(Monitor monitor) {
		this.monitor = monitor;
	}

	public void run() {
		try {
			TimeUnit.SECONDS.sleep(3);
			System.out.println("i'm going.");
			monitor.gotMessage();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Monitor implements Runnable {
	private volatile boolean go = false;
	private volatile boolean stop = false;
	private int times = 0;

	public synchronized void gotMessage() throws InterruptedException {
		go = true;
		notify();
	}

	public synchronized void watching() throws InterruptedException {
		while (!stop) {
			while (go == false)
				wait();
			System.out.println("He has gone." + times++);
			go = false;
		}
	}

	public synchronized void stop() {
		stop = true;
	}

	public void run() {
		try {
			watching();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Wait {
	public static void main(String[] args) {
		Monitor monitor = new Monitor();
		MyObject o = new MyObject(monitor);
		// new Thread(o).start();
		new Thread(monitor).start();

		try {
			int i = 0;
			while (i++ < 10) {
				Thread.sleep(1000);
				monitor.gotMessage();
				if (i == 4) {
					monitor.stop();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}