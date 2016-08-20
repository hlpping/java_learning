package com.tjbklx1.thread.trandition;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 
 * @author shuang
 * @version 1.0 Oct 28, 2011
 * 多线程 定时器 TimerTask
 */
public class TimerTest {
	static int count =0;
	public static void main(String[] args) {
		
//		test1();
//		test2();
		test3();
//		test4();
		
			
	}

	private static void test4() {
		class MyTimerTask extends TimerTask{
			public void run() {
				count =(count+1)%2;				
				System.out.println("boooooo ");				
				new Timer().schedule(new MyTimerTask(){}, 2000+2000*count);
			}			
		}		
		new Timer().schedule(new MyTimerTask(), 2000);
		while(true){
			System.out.println(new Date().getSeconds());			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 线程中有启动线程 并安排定时器
	 */
	private static void test3() {
		new Timer().schedule(new TimerTask(){
			public void run() {
				System.out.println("boooooo ");
				
				new Timer().schedule(new TimerTask(){
					public void run() {
						System.out.println("boooooo ");						
					}}, 4000);				
			}}, 2000);
		while(true){
			System.out.println(new Date().getSeconds());			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void test2() {
		new Timer().schedule(new TimerTask(){
			public void run() {
				System.out.println("boooooo ");
			}}, 2000,5000);
		while(true){
			System.out.println(new Date().getSeconds());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 10秒钟后启动线程
	 */
	private static void test1() {
		new Timer().schedule(new TimerTask(){
			public void run() {
				System.out.println("boooooo ");
			}}, 10000);
		while(true){
			System.out.println(new Date().getSeconds());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
