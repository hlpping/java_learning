package basestrong2.listener.demo2;

public class Main {
	public static void main(String[] args) {
		
		Person p =new Person();
		p.addPersonListener(new PersonListener() {			
			public void eating() {
				System.out.println("你还真吃啊");
				
			}
		});
		p.eat();
	}

}
