package base.day12_Set;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		//1
		/*
		TreeSet<Person> set=new TreeSet<Person>();
		*/
		
		//2
		TreeSet<Person> set = new TreeSet<Person>(new Comparator<Person>() {
			// 在TreeSet的构造函数中传入一个Compartor, 重写compare方法指定比较算法
			public int compare(Person p1, Person p2) {
				int nameGap = p1.getName().compareTo(p2.getName());
				return nameGap != 0 ? nameGap : p1.getAge() - p2.getAge();
			}
		});
		
		
		set.add(new Person("zs", 21)); // 第一个对象肯定可以存
		set.add(new Person("ls", 22)); // 将第二个对象强转为Comparable, 调用其compareTo方法和前一个对象比较. 如果是负数存左边, 如果是正数存右边, 0就不存.
		set.add(new Person("ww", 20));
		set.add(new Person("zl", 19));
		set.add(new Person("sq", 21));
		set.add(new Person("zb", 21));
		set.add(new Person("zb", 21));
		set.add(new Person("zb", 20));

		for (Person p : set)
			System.out.println(p);
		

		// 默认比较方式是自然顺序, 也就是对象实现Comparable之后的compareTo方法返回的顺序
		// 构造函数中传入一个Compartor, 重写compare方法指定比较算法,则重写compare优先
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
