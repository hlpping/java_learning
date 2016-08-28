package com.tjbklx1.thread.base.demo02;


public class App {
	
	public void test01(){
		TicketSeller ticketSeller = new TicketSeller();
		new Thread(ticketSeller,"seller1").start();
		new Thread(ticketSeller,"seller2").start();
		new Thread(ticketSeller,"seller3").start();
		new Thread(ticketSeller,"seller4").start();
	}
	
	public void test02(){
		TicketSeller2 ticketSeller = new TicketSeller2();
		new Thread(ticketSeller,"seller1").start();
		new Thread(ticketSeller,"seller2").start();
		new Thread(ticketSeller,"seller3").start();
		new Thread(ticketSeller,"seller4").start();
	}
	
	public void test03(){
		TicketSeller3 ticketSeller = new TicketSeller3();
		new Thread(ticketSeller,"seller1").start();
		new Thread(ticketSeller,"seller2").start();
		new Thread(ticketSeller,"seller3").start();
		new Thread(ticketSeller,"seller4").start();
	}
	
	public void test04(){
		TicketSeller4 ticketSeller = new TicketSeller4();
		new Thread(ticketSeller,"seller1").start();
		new Thread(ticketSeller,"seller2").start();
		new Thread(ticketSeller,"seller3").start();
		new Thread(ticketSeller,"seller4").start();
	}
}
