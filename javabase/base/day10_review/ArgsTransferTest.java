package base.day10_review;

public class ArgsTransferTest {
	public static void main(String[] args) {
		/**
		 * 	5
			lisi
			good
		 */
		int i=5;
		run(i);
		System.out.println(i);	
		
		Person p = new Person("张三", 20);
		run(p);
		System.out.println(p.getName());
		
		String str="good";
		run(str);
		System.out.println(str);
	}

	private static void run(String str) {
		str="bad";
	}

	private static void run(Person p) {
		p.setName("lisi");
	}

	private static void run(int i) {
		i++;		
	}
	
}
