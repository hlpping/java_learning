package com.tjbklx1.thread.base.demo03;
public class PrintTest {
	private static int num =1;
	private static String lock="lock";
	private static int flag=1;
		
	public static void main(String[] args) {
		
		new Thread(new Runnable(){
			public void run() {
				for(int j=0;j<5;j++){
					synchronized (lock) {
						if(flag!=1){
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						for(int i=0;i<5;i++){
							System.out.println(Thread.currentThread().getName() + ": " + num++);
						}
						System.out.println();
						flag=2;
						lock.notify();
					}
				}
			}},"线程一").start();
		new Thread(new Runnable(){
			public void run() {
				for(int j=0;j<5;j++){
					synchronized (lock) {
						if(flag!=2){
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						for(int i=0;i<5;i++){
							System.out.println(Thread.currentThread().getName() + ": " + num++);
						}
						System.out.println();
						flag=1;
						lock.notify();
					}
				}
			}},"线程二").start();
		
	}

}
