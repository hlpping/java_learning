package com.tjbklx1.thread.base.demo02;

class TicketSeller4 implements Runnable {
	private int ticket = 100;
	private String lock = "lock";

	public void run() {
		while (true) {
			String name = Thread.currentThread().getName();
			if ("售票员1".equals(name) || "售票员2".equals(name)) {
				if (!sell())
					break;
			} else {
				synchronized (lock) {
					synchronized (this) {
					}
					if (ticket > 0) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + ": 卖出了第" + ticket-- + "号票.");
					} else {
						break;
					}
				}
			}
		}
	}

	private synchronized boolean sell() {
		synchronized (lock) {

		}
		if (ticket > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": 卖出了第" + ticket-- + "号票.");
			return true;
		} else {
			return false;
		}
	}
}
