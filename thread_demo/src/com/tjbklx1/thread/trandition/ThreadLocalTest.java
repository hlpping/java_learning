package com.tjbklx1.thread.trandition;

import java.util.Random;

/**
 * ThreadLocal 的应用技巧
 * 
 * @author shuang
 * @version 1.0 Nov 1, 2011
 */
public class ThreadLocalTest {
	private static ThreadLocal<Integer> x=new ThreadLocal<Integer>();

	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()
							+ " has put data :" + data);
					x.set(data);
					new A().get();
					new B().get();
				}
			}).start();			
		}
	}
	static class A {
		public void get() {
			int data = x.get();
			System.out.println("A from " + Thread.currentThread().getName()
					+ " get data :" + data);
		}
	}
	static class B {
		public void get() {
			int data = x.get();
			System.out.println("B from " + Thread.currentThread().getName()
					+ " get data :" + data);
		}
	}
}
