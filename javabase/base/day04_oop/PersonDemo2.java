package base.day04_oop;

public class PersonDemo2 {
	public static void main(String[] args) {
		Persons p = new Persons();
		// p.name = "张三";
		p.setName("张三");
		// System.out.println(p.name);

		System.out.println(p.getName());
		// System.out.println(p.age);

	}
}

class Persons { // 标准的JavaBean需要将所有的属性私有(private), 然后对外提供公有的get,set方法

	private String name; // 使用private将类的属性私有化, 类外部就不能直接访问了
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}