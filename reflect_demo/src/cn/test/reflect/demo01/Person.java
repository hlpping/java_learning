package cn.test.reflect.demo01;

class Person {

	private String name;
	private int age;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + " : " + age;
	}

	public void fun() {
		System.out.println("这是Person类无参的fun方法, 当前对象的name是: " + name
				+ ", age是: " + age);
	}

	public void fun(int i) {
		System.out.println("这是Person类有一个int参数的fun方法, 当前对象的name是: " + name
				+ ", age是: " + age + ", int参数是: " + i);
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

	private void privateMethod() {
	}

}