package base.day13_Map;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class TreeMapTest {
	public static void main(String[] args) {
//		test1();
//		test2();
		test3();
	}
	
	private static void test1() {
		TreeMap<Person, String> map = new TreeMap<Person, String>();
		map.put(new Person("zs", 25), "A");
		map.put(new Person("ls", 22), "B");
		map.put(new Person("ww", 21), "A");
		map.put(new Person("zl", 21), "C");
		map.put(new Person("zl", 21), "C");
		map.put(new Person("zl", 21), "A");

		for (Person p : map.keySet())
			System.out.println(p + " = " + map.get(p));	
	}
	
	private static void test2() {
		TreeMap<Person, String> map = new TreeMap<Person, String>(
			new Comparator<Person>(){
				public int compare(Person o1, Person o2) {
					int nameGap = o1.getName().compareTo(o2.getName());
					return nameGap != 0 ? nameGap : o1.getAge() - o2.getAge();
				}				
			});
		map.put(new Person("zs", 25), "A");
		map.put(new Person("ls", 22), "B");
		map.put(new Person("ww", 21), "A");
		map.put(new Person("zl", 21), "C");
		map.put(new Person("zl", 21), "C");
		map.put(new Person("zl", 21), "A");

		for (Person p : map.keySet())
			System.out.println(p + " = " + map.get(p));	
	}
	
	private static void test3() {
		TreeMap<Person, String> map = new TreeMap<Person, String>();
		map.put(new Person("zs", 25), "A");
		map.put(new Person("ls", 22), "B");
		map.put(new Person("ww", 21), "A");
		map.put(new Person("zl", 21), "C");
		map.put(new Person("zl", 21), "C");
		map.put(new Person("zl", 21), "A");		
		
		Set<Entry<Person, String>> entrySet = map.entrySet(); // 获取map中所有记录组成的Set集合

		// 定义一个TreeSet, 这个TreeSet中每一个元素都是Entry, 并且可以按照Entry的value排序
		TreeSet<Entry<Person, String>> set = new TreeSet<Entry<Person, String>>(
				new Comparator<Entry<Person, String>>() {
					
					public int compare(Entry<Person, String> o1, Entry<Person, String> o2) {
						int gradeGap = o1.getValue().compareTo(o2.getValue()); // 获取成绩差值
						return gradeGap != 0 ? gradeGap : o1.getKey().getName().compareTo(o2.getKey().getName());
					}
		});
		set.addAll(entrySet);	// 将原有的entrySet全部装入set进行排序

		for (Entry<Person, String> e : set)
			System.out.println(e.getKey() + " = " + e.getValue());
	}	
}
