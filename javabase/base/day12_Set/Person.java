package base.day12_Set;

public class Person  implements Comparable<Person>{
	private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
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
	//重写toString方法
	public String toString() {
		return name + " : " + age;
	}
	
	public int hashCode() {
		final int prime = 31; // 素数, 质数
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result; // 只要属性相同, 那么算出的结果就相同, 而且让这个值保持在一个范围之内.
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	// 此方法返回一个int值, 正数, 负数, 或0
	public int compareTo(Person o) {
		int ageGap = this.age - o.age; // 计算年龄的差值
		return ageGap != 0 ? ageGap : this.name.compareTo(o.name); // 如果年龄不同, 直接返回年龄差值, 如果年龄相同, 返回名字差值
	}

	/*	// 只要保证属性相同, hashCode相同就可以, 最好让这个值在一定范围内
	public int hashCode() {
		return (age + name.length()) % 8;		// 如果name和age相同, 得到的结果相同. 而且这个值只能是从0-7
	}
	*/
	
}
