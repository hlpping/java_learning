package base.day19_thread;

public class TicketSellerDemo01 {

	public static void main(String[] args) {
//		test1();
		TicketSeller ticketSeller = new TicketSeller();
		new Thread(ticketSeller,"seller1").start();
		new Thread(ticketSeller,"seller2").start();
		new Thread(ticketSeller,"seller3").start();
		new Thread(ticketSeller,"seller4").start();
	}

	private static void test1() {
		TicketSeller ticketSeller1 = new TicketSeller();
		TicketSeller ticketSeller2 = new TicketSeller();
		TicketSeller ticketSeller3 = new TicketSeller();
		TicketSeller ticketSeller4 = new TicketSeller();
		
//		ticketSeller1.start();
//		ticketSeller2.start();
//		ticketSeller3.start();
//		ticketSeller4.start();
	}

}
/*
class TicketSeller extends Thread{
	private int ticket = 100;
	public void run() {
		while(true){
			if(ticket>0){
				System.out.println(Thread.currentThread().getName() + ": 卖出了第" + ticket-- + "号票.");
			}else
				break;			
		}	
	}
}
*/
/*
class TicketSeller implements Runnable{
	private int ticket = 100;
	private String lock="lock";
	public void run() {
		while(true){
			System.out.println("hi");
			synchronized (lock) {
				
				if(ticket>0){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ": 卖出了第" + ticket-- + "号票.");
				}else{
					System.out.println(Thread.currentThread().getName() + "sell ok");
					break;	
				}
			}
		}			
	}	
}
*/
/*
class TicketSeller implements Runnable{
	private int ticket = 100;
	private String lock="lock";
	public void run() {
		while(true){
			String name = Thread.currentThread().getName();
			if ("售票员1".equals(name) || "售票员2".equals(name)) {
				if (!sell())
					break;
			} else{
				synchronized (lock) {				
					if(ticket>0){
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + ": 卖出了第" + ticket-- + "号票.");
					}else{
						break;	
					}
				}
			}	
		}
	}
	private boolean sell() {
		if (ticket > 0) {
			try {
				Thread.sleep(10);
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
*/
class TicketSeller implements Runnable{
	private int ticket = 100;
	private String lock="lock";
	public void run() {
		while(true){
			String name = Thread.currentThread().getName();
			if ("售票员1".equals(name) || "售票员2".equals(name)) {
				if (!sell())
					break;
			} else{
				synchronized (lock) {		
					synchronized(this){						
					}
					if(ticket>0){
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + ": 卖出了第" + ticket-- + "号票.");
					}else{
						break;	
					}
				}
			}	
		}
	}
	private synchronized boolean sell() {
		synchronized(lock){
			
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
