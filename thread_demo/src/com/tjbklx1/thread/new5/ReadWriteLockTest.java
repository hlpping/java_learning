package com.tjbklx1.thread.new5;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁 
 * @author shuang
 * @date Nov 5, 2011
 */
public class ReadWriteLockTest {
	public static void main(String[] args) {
		final Queue queue =new Queue();
//		for(int i=0;i<3;i++){
			new Thread(){
				public void run() {
					while(true){
						queue.get();
					}
			}}.start();
			
			new Thread(){
				public void run() {
					while(true){
						queue.put(new Random().nextInt(1000));
					}
			}}.start();
//		}		
	}
}
class Queue{
	//共享数据，只能有一个线程能写该数据，但可以有多个线程同时读该数据。
	private Object data =null;
	ReadWriteLock readWriteLock =new ReentrantReadWriteLock();
	
	public void get(){
		//获得读锁
		readWriteLock.readLock().lock();		
		try {
			System.out.println(Thread.currentThread().getName()+" be ready to read data!");
			Thread.sleep((long) (Math.random()*1000));
			System.out.println(Thread.currentThread().getName() + "have read data :" + data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			readWriteLock.readLock().unlock();
		}
	}
	
	public void put(Object data){
		//获得写锁
		readWriteLock.writeLock().lock();		
		try {
			System.out.println(Thread.currentThread().getName()+" be ready to read data!");
			Thread.sleep((long) (Math.random()*1000));
			this.data=data;
			System.out.println(Thread.currentThread().getName() + "have read data :" + data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			readWriteLock.writeLock().unlock();
		}
	}
	
}