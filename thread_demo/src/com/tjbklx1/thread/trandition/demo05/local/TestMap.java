package com.tjbklx1.thread.trandition.demo05.local;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ThreadLocal 的应用技巧  ,Map<Thread,Integer> 
 * 
 * @author shuang
 * @version 1.0 Nov 1, 2011
 */
public class TestMap {
	private static Map<Thread,Integer> map = new HashMap<Thread, Integer>();

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()
							+ " has put data :" + data);
					map.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

	static class A {
		public void get() {
			int data = map.get(Thread.currentThread());
			System.out.println("A from " + Thread.currentThread().getName()
					+ " get data :" + data);
		}
	}

	static class B {
		public void get() {
			int data = map.get(Thread.currentThread());
			System.out.println("B from " + Thread.currentThread().getName()
					+ " get data :" + data);
		}
	}
}
