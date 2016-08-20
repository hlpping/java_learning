package com.tjbklx1.thread.base.demo01;

import org.junit.Test;

public class ThreadDemo01 {

	@Test
	public void test01() throws InterruptedException {
		new MyThread01().start();
	}
	
	@Test
	public void test02() throws InterruptedException {
		new MyThread01().start();
		for(int i=0;i<100;i++){
			System.out.println("main "+i);
			Thread.sleep(100);
		}
	}
	
	@Test
	public void test03() throws InterruptedException {
		MyThread01 myThread01 =new MyThread01();
		myThread01.setDaemon(true);
		myThread01.start();
		
		for(int i=0;i<100;i++){
			System.out.println("main: " + i + ", name: " + Thread.currentThread().getName());
			if (i == 50)
				myThread01.join(); 
			// 让myThread线程加入到当前线程, 当前线程暂停, 等待加入的线程执行完毕, 之后继续
			Thread.sleep(1);
		}
	}
}
