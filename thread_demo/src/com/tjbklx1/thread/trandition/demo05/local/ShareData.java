package com.tjbklx1.thread.trandition.demo05.local;

import java.util.Random;

/**
 * 线程范围内的共享数据
 * 
 * @author shuang
 * @version 1.0 Nov 1, 2011
 */
public class ShareData {
	private static int data = 0;

	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				public void run() {
					data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()
							+ " has put data :" + data);
					new A().get();
					new B().get();
				}
			}).start();			
		}
	}

	static class A {
		public void get() {
			System.out.println("A from " + Thread.currentThread().getName()
					+ " get data :" + data);
		}
	}

	static class B {
		public void get() {
			System.out.println("B from " + Thread.currentThread().getName()
					+ " get data :" + data);
		}
	}
}
