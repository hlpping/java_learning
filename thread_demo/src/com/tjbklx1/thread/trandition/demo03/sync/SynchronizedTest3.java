package com.tjbklx1.thread.trandition.demo03.sync;

/**
 * 
 * @author shuang
 * @version 1.0 Oct 28, 2011 传统线程互斥
 */
public class SynchronizedTest3 {
	public static void main(String[] args) {
		new SynchronizedTest3().init();
	}

	/**
	 * 利用初始化方法调用内部类
	 */
	private void init() {
		final Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("线程1111");
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output2("线程2");
				}
			}
		}).start();
	}

	// 输出文字的代码
	class Outputer {
		public void output(String name) {
			int len = name.length();
			// 相当于门闩
			synchronized (this) 
			{
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		public synchronized void output2(String name) {
			int len = name.length();
			for (int i = 0; i < len; i++)
				System.out.print(name.charAt(i));
			System.out.println();
		}		
	}
}
