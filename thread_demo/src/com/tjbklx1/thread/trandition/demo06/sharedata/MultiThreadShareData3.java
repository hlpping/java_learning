package com.tjbklx1.thread.trandition.demo06.sharedata;
/**
 * 没有完善
 * @author Administrator
 *
 */
public class MultiThreadShareData3 {
	public static void main(String[] args) {
		final ShareData4 data = new ShareData4();
		
		new Thread(new MyRunnable1(data)).start();
		new Thread(new MyRunnable2(data)).start();
	}
}
class ShareData4 {

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

class MyRunnable1 implements Runnable {
	private ShareData4 data;
	
	public MyRunnable1(ShareData4 data){
		this.data=data;
	}
	public void run() {
		data.increment();
	}
}

class MyRunnable2 implements Runnable {
	private ShareData4 data;
	
	public MyRunnable2(ShareData4 data){
		this.data=data;
	}
	public void run() {
		data.decrement();
	}
}
