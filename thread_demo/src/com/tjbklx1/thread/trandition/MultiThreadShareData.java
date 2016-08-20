package com.tjbklx1.thread.trandition;
/**
 * 多线程共享数据 方法1
 * @author Administrator
 *
 */
public class MultiThreadShareData {
	public static void main(String[] args) {
		ShareData1 data = new ShareData1();
		new Thread(data).start();
		new Thread(data).start();		
	}
}
class ShareData1 implements Runnable{
	private int count = 100;
	public void run() {
		while(true){
			count--;
		}
	}
	private int j = 0;
	public synchronized void increment(){
		j++;
	}		
	public synchronized void decrement(){
		j--;
	}	
}
