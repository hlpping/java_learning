package com.tjbklx1.thread.trandition;
/**
 * 
 * @author shuang
 * @version 1.0 Oct 28, 2011
 * 传统线程互斥
 */
public class SynchronizedTest {
	public static void main(String[] args) {
		new SynchronizedTest().init();
	}
	/**
	 * 利用初始化方法调用内部类
	 */
	private void init() {
		final Outputer outputer=new Outputer();
		new Thread(new Runnable(){
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("线程1111");					
				}
			}			
		}).start();
		
		new Thread(new Runnable(){
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("线程2");					
				}
			}			
		}).start();		
	}
	//输出文字的代码
	class Outputer{
		public void output(String name){
			int len =name.length();
			for(int i=0;i<len;i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
}
