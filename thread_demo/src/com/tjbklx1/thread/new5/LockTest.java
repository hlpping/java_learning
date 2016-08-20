package com.tjbklx1.thread.new5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock 实现线程间的通信
 * 
 * @author shuang
 * @date Nov 5, 2011
 */
public class LockTest {
	public static void main(String[] args) {
		new LockTest().init();
	}

	private void init() {
		final Outputer outputer=new Outputer();
		for(int j=0;j<10;j++){
			
			new Thread(new Runnable(){
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output1("zzzzzzzzzzzzzzzzzzzzzzzz");
				}}).start();
			new Thread(new Runnable(){
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output1("sssssssssssssssssssssssss");
				}}).start();
		}
	}

	static class Outputer {
		Lock lock = new ReentrantLock();

		public void output1(String name) {
			int len = name.length();
			lock.lock();
			try {
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			} finally {
				lock.unlock();
			}
		}
/*
		public synchronized void output2(String name) {
			int len = name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}

		public static synchronized void output3(String name) {
			int len = name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
*/
	}
}
