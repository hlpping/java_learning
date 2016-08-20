package com.tjbklx1.thread.base.demo03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JDK5ThreadPrintDemo {

	public static int num=1;
	private static Lock lock=new ReentrantLock();
	private static Condition c1 = lock.newCondition(); // 从lock上创建一个分支
	private static Condition c2 = lock.newCondition();
	private static Condition c3 = lock.newCondition();
	private static int flag = 1;
	
	
	public static void main(String[] args) {
		new Thread(new Runnable(){
			public void run() {
				for(int j=0;j<5;j++){
					lock.lock();	// 开始同步, 相当于 synchronized()
					if(flag!=1){
						try {
							c1.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for(int i=0;i<5;i++)
						System.out.println(Thread.currentThread().getName() + ": " + num++);
					System.out.println();
					flag = 2;
					c2.signal(); // 唤醒
					lock.unlock(); // 同步结束, 这里相当于同步代码快结束					
				}
			}},"线程1").start();
		new Thread(new Runnable(){
			public void run() {
				for(int j=0;j<5;j++){
					lock.lock();
					if(flag!=2){
						try {
							c2.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for(int i=0;i<5;i++)
						System.out.println(Thread.currentThread().getName() + ": " + num++);
					System.out.println();
					flag = 3;
					c3.signal(); // 唤醒
					lock.unlock(); // 同步结束, 这里相当于同步代码快结束					
				}
			}},"线程2").start();
		new Thread(new Runnable(){
			public void run() {
				for(int j=0;j<5;j++){
					lock.lock();
					if(flag!=3){
						try {
							c3.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for(int i=0;i<5;i++)
						System.out.println(Thread.currentThread().getName() + ": " + num++);
					System.out.println();
					flag = 1;
					c1.signal(); // 唤醒
					lock.unlock(); // 同步结束, 这里相当于同步代码快结束					
				}
			}},"线程3").start();
	}
}
