package com.tjbklx1.thread.trandition;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程范围内的共享数据2
 * 
 * @author shuang
 * @version 1.0 Nov 1, 2011
 */
public class ShareData2 {
	private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();

	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()
							+ " has put data :" + data);
					threadData.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}).start();			
		}
	}

	static class A {
		public void get() {
			int data = threadData.get(Thread.currentThread());
			System.out.println("A from " + Thread.currentThread().getName()
					+ " get data :" + data);
		}
	}

	static class B {
		public void get() {
			int data = threadData.get(Thread.currentThread());
			System.out.println("B from " + Thread.currentThread().getName()
					+ " get data :" + data);
		}
	}
}
