package base.day10_review;

public class test {
	public static void main(String[] args) {
		final int x = 98;
//		x = 99;
		final Person p = new Person("张三", 20);
		p.setName("李四");
//				p = new Person("张三", 20);
		
		System.out.println(p.getName());
	}
}
