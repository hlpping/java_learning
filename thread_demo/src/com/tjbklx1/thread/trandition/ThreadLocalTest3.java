package com.tjbklx1.thread.trandition;

import java.util.Random;

/**
 * ThreadLocal ???
 * 
 * @author shuang
 * @version 1.0 Nov 1, 2011
 */
public class ThreadLocalTest3 {
	private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
	private static ThreadLocal<MyThreadScopeData2> myThreadScopeData = new ThreadLocal<MyThreadScopeData2>();

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()
							+ " has put data :" + data);
					
					MyThreadScopeData2.getInstance().setName(""+data);
					MyThreadScopeData2.getInstance().setAge(25);
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

			MyThreadScopeData2 mydata =MyThreadScopeData2.getInstance();
			System.out.println("A from " + Thread.currentThread().getName()+" "+mydata.getName()
			+" age "+mydata.getAge());
			
		}
	}

	static class B {
		public void get() {
			int data = x.get();
			System.out.println("B from " + Thread.currentThread().getName()
					+ " get data :" + data);
			
			MyThreadScopeData2 mydata =MyThreadScopeData2.getInstance();
			System.out.println("B from " + Thread.currentThread().getName()+" "+mydata.getName()
			+" age "+mydata.getAge());
		}
	}
}
//懒汉模式
class MyThreadScopeData2 {
	private MyThreadScopeData2(){}
//	private static MyThreadScopeData2 instance =null;
	public static /* synchronized */ MyThreadScopeData2 getInstance (){
		
		MyThreadScopeData2 instance =map.get();
		if(instance == null){
			instance =new MyThreadScopeData2();
			map.set(instance);
		}
		return instance;
	}
	
	private static ThreadLocal<MyThreadScopeData2> map =new ThreadLocal<MyThreadScopeData2>();
	
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