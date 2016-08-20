package com.tjbklx1.thread.trandition;
/**
 * 线程同步通信 ???
 * 
 * 子线程循环10次,接着主线程循环100次,接着
 * 子线程循环10次,接着主线程循环100次
 * 如此循环50次
 * @author shuang
 * @version 1.0 Oct 28, 2011
 */
public class SynchronizedCommunication {

	public static void main(String[] args) {
		final Business business=new Business();
		new Thread(new Runnable(){
			public void run() {
				for(int i=1;i<=3;i++){
					business.sub(i);
				}
			}}).start();
		
		for(int i=1;i<=3;i++){
			business.main(i);
		}
	}

}
class Business {
	private boolean bClock=true;
	public synchronized void sub(int i) {
		while(!bClock){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j=0;j<10;j++){
			System.out.println("sub thread sequence of " + j + ",loop of " + i);
		}
		//循环结束后设置 唤醒符号,唤醒主线程
		bClock=false;
		this.notify();
	}
	
	public synchronized void main(int i) {
		while(!bClock){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j=0;j<15;j++){	//100 15 方便
			System.out.println("main thread sequence of " + j + ",loop of " + i);
		}
		//循环结束后设置 唤醒符号,唤醒主线程
		bClock=true;
		this.notify();
	}
	
}