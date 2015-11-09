package base.day19_thread;

public class ThreadDemo01 {
	public static void main(String[] args) throws InterruptedException {
//		test1();
		MyThread01 myThread01 =new MyThread01();
		myThread01.setDaemon(true);
		myThread01.start();
		
//		new MyThread01().start();
		
		for(int i=0;i<100;i++){
			System.out.println("main: " + i + ", name: " + Thread.currentThread().getName());
			if (i == 50)
				myThread01.join(); 
			// 让myThread线程加入到当前线程, 当前线程暂停, 等待加入的线程执行完毕, 之后继续
			Thread.sleep(1);
		}
	}

	private static void test1() throws InterruptedException {
		new MyThread01().start();
		for(int i=0;i<100;i++){
			System.out.println("main "+i);
			Thread.sleep(100);
		}
	}
}
class MyThread01 extends Thread{
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("run: " + i + ", name: " + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}