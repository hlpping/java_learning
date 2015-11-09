package base.day19_thread;

public class DataBaseDemo {
	public static void main(String[] args) {
		DataBase db = new DataBase();
		new Thread(new DBA(db)).start(); // 开启一个数据库管理员线程
		new Thread(new Developer(db)).start();
	}
}
class DataBase {
	private String name;
	private String gender;
	private boolean update; // 这个变量用来标记数据是否是最新的

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
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
