package com.tjbklx1.thread.base.demo02;

class TicketSeller2 implements Runnable {
	private int ticket = 100;
	private String lock = "lock";

	public void run() {
		while (true) {
			System.out.println("hi");
			synchronized (lock) {

				if (ticket > 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ": 卖出了第" + ticket-- + "号票.");
				} else {
					System.out.println(Thread.currentThread().getName() + "sell ok");
					break;
				}
			}
		}
	}
}