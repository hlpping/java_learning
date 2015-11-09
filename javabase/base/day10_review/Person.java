package base.day10_review;

public class Person {
	private String name;
	private int age;

	public Person() {
		this("未录入", -1);
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void Person() { // 不报错, 但不推荐这么用
		System.out.println("Person方法");
	}

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

	public void run() {
		System.out.println(name + " is running.");
	}

	public boolean equals(Object obj) {
		if (this == obj) // 如果传入对象和该对象地址相同, 则是同一个对象, 直接返回true
			return true;
		if (obj == null) // 如果传入对象是空, 那么肯定不一样, 因为可以运行这个方法, 当前对象就不为空
			return false;
		if (this.getClass() != obj.getClass()) // 判断是否是同一个类型, 如果不是返回false
			return false;
		final Person other = (Person) obj; // 如果是同一个类型, 将传入对象强转为Person
		if (age != other.age) // 如果年龄不同, 则返回false
			return false;
		if (name == null) { // 如果自己的name为空
			if (other.name != null) // 如果传入对象的name不为空, 返回false
				return false;
		} else if (!name.equals(other.name)) // 如果自己name不为空, 并且和传入的name不同, 返回false
			return false;
		return true; // 如果上面条件都未满足, 则是所有属性都相同. 返回true
	}

}
