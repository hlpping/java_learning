package base.day05_oop_static;

public class StaticVariableTest {
	public static void main(String[] args) {
		TicketSeller seller1 = new TicketSeller("售票员1");
		TicketSeller seller2 = new TicketSeller("售票员2");
		TicketSeller seller3 = new TicketSeller("售票员3");
		
		seller1.sell();
		seller1.sell();
		seller1.sell();
		
		seller2.sell();
		seller2.sell();
		
		seller3.sell();
	}
}

class TicketSeller {
	static int tickets = 1000;
	String name;

	public TicketSeller(String name) {
		this.name = name;
	}

	public void sell() {
		System.out.println(name + "卖出了第" + tickets-- + "号票");
	}
}