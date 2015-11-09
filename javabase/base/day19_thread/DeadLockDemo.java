package base.day19_thread;

public class DeadLockDemo {
	public static void main(String[] args) {
		new Thread().start();
		new Thread().start();
		
		new Thread(new Runnable() {
			public void run() {
				synchronized ("刀叉") {
					System.out.println(Thread.currentThread().getName() + ": 你把筷子给我, 我就给你刀叉.");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized ("筷子") {
						System.out.println(Thread.currentThread().getName() + ": 好, 给你刀叉.");
					}
				}
			}
		}, "中国人").start();

		new Thread(new Runnable() {
			public void run() {
				synchronized ("筷子") {
					System.out.println(Thread.currentThread().getName() + ": 你先给我刀叉, 我才给你筷子.");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized ("刀叉") {
						System.out.println(Thread.currentThread().getName() + ": 好, 给你筷子.");
					}
				}
			}
		}, "美国人").start();
	}
}
