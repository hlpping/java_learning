package com.tjbklx1.thread.base.demo04;

class DBA implements Runnable {
	private DataBase db;
	private int times;

	public DBA(DataBase db) {
		this.db = db;
	}

	public void run() {
		while (true) {
			synchronized (db) {
				if (db.isUpdate())
					try {
						db.wait(); // 判断数据如果是新的, 说明刚更新过, 等待, Object类中的方法, 所有类都会继承
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				if (times++ % 2 == 0) {
					db.setName("张金");
					db.setGender("男");
				} else {
					db.setName("门雪飞");
					db.setGender("女");
				}
				db.setUpdate(true); // 当管理员更新数据之后, 将数据设置为最新的
				db.notify(); // 唤醒在该锁旗标上等待的一个线程
			}
		}
	}
}