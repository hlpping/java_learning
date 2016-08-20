package com.tjbklx1.thread.trandition;

import java.util.Random;

/**
 * ThreadLocal ???
 * 
 * @author shuang
 * @version 1.0 Nov 1, 2011
 */
public class ThreadLocalTest2 {
	private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
	private static ThreadLocal<MyThreadScopeData> myThreadScopeData = new ThreadLocal<MyThreadScopeData>();

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()
							+ " has put data :" + data);
					
					MyThreadScopeData myData = new MyThreadScopeData();
					myData.setName("name" + data);
					myData.setAge(25);
					myThreadScopeData.set(myData);
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
			
			MyThreadScopeData myData = myThreadScopeData.get();
			System.out.println("A from " + Thread.currentThread().getName()+" "+myData.getName()
			+" age "+myData.getAge());
		}
	}

	static class B {
		public void get() {
			int data = x.get();
			System.out.println("B from " + Thread.currentThread().getName()
					+ " get data :" + data);
			
			MyThreadScopeData myData = myThreadScopeData.get();
			System.out.println("B from " + Thread.currentThread().getName()+" "+myData.getName()
			+" age "+myData.getAge());
		}
	}
}

class MyThreadScopeData {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}