package com.tjbklx1.thread.trandition;

public class ThreadTest {
	public static void main(String[] args) {
		
//		test1();
//		test2();		
	}
	private static void test2() {
		new Thread(new Runnable(){
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
						System.out.println("2 runnable "+Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}}){
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
						System.out.println("1 thread "+Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}.start();
	}

	private static void test1() {
		Thread thread =new Thread(){
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
						System.out.println("1 "+Thread.currentThread().getName());
						System.out.println("2 "+this.getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		thread.start();
		
		Thread thread2=new Thread(new Runnable(){

			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}});
		thread2.start();
	}
}
