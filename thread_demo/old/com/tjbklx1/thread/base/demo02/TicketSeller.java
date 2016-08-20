package com.tjbklx1.thread.base.demo02;

class TicketSeller extends Thread {
	private int ticket = 100;

	public void run() {
		while (true) {
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + ": 卖出了第" + ticket-- + "号票.");
			} else
				break;
		}
	}
}