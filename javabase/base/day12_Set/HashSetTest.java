package base.day12_Set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		
		test1();
//		test2();
	}
	private static void test2() {
		HashSet<Person> set = new HashSet<Person>(); 
		set.add(new Person("李毅", 21));
		set.add(new Person("邱家恒", 22));
		set.add(new Person("仲衡", 20));
		set.add(new Person("黄丹", 21));
		set.add(new Person("张金", 21));

		//		test1(set);

		set.add(new Person("王青", 21));
		set.add(new Person("王青", 21));

		for (Person person : set)
			System.out.println(person);

		System.out.println();

		Iterator<Person> iter = set.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
	}
	private static void test1() {
		HashSet<Person> set = new HashSet<Person>(); 
		Person p = new Person("王青", 21);
		set.add(p);
		set.add(p);

		for (Person person : set) {
			System.out.println(person);
		}
	}
}
