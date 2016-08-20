package com.tjbklx1.thread.base.demo04;

class Developer implements Runnable { // Programer Coder
	private DataBase db;

	public Developer(DataBase db) {
		this.db = db;
	}

	public void run() {
		while (true) {
			synchronized (db) {
				if (!db.isUpdate())
					try {
						db.wait(); // 如果数据是旧的, 那么等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				System.out.println(db.getName() + " : " + db.getGender());
				db.setUpdate(false); // 当程序员读取数据之后, 将数据设置为旧的
				db.notify(); // 唤醒在该锁旗标上等待的一个线程
			}
		}
	}
}