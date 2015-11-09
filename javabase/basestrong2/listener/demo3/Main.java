package basestrong2.listener.demo3;

public class Main {
	public static void main(String[] args) {
		
		Person p =new Person();
		System.out.println(p);
		p.addPersonListener(new PersonListener() {			
			public void eating(PersonEvent e) {
				System.out.println("你还真吃啊"+e.getSource());				
			}
		});
		p.eat();
	}

}
