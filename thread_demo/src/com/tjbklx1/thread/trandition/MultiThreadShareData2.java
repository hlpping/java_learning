package com.tjbklx1.thread.trandition;
/**
 * 没有完善
 * @author Administrator
 *
 */
public class MultiThreadShareData2 {
	public static void main(String[] args) {
		final ShareData3 data = new ShareData3();
		new Thread(new Runnable() {
			public void run() {
				data.decrement();
			}
		}).start();
		new Thread(new Runnable(){
			public void run() {
				data.increment();
			}}).start();		
	}
}
class ShareData3 {
//	private int count = 100;
//	public void run() {
//		while(true){
//			count--;
//		}
//	}
	private int j = 0;
	public synchronized void increment(){
		j++;
		System.out.println(j);
	}		
	public synchronized void decrement(){
		j--;
		System.out.println(j);
	}	
}
