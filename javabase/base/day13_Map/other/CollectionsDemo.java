package base.day13_Map.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

import base.day13_Map.Person;


public class CollectionsDemo {
	@Test
	public void test1(){
		Person p1 = new Person("张金", 22);
		Person p2 = new Person("邱家恒", 23);
		Person p3 = new Person("马磊", 24);
		Person p4 = new Person("李毅", 25);

		ArrayList<Person> list = new ArrayList<Person>();
		Collections.addAll(list, p1,p2,p3,p4);
		for(Person p:list){
			System.out.println(p);
		}
		
	}
	@Test
	public void test2(){
		ArrayList<String> list = new ArrayList<String>();
		Collections.addAll(list, "b", "c", "d", "e", "f", "g", "a");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		System.out.println(Collections.binarySearch(list, "a"));
	}
	@Test
	public void test3(){
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		Collections.addAll(list1, "a", "b", "c");
		Collections.addAll(list2, "d", "e", "f", "g");
		Collections.copy(list2, list1); // 从list1复制到list2, 覆盖原有位置上的元素
		System.out.println(list2);
	}
	@Test
	public void test4(){
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		Collections.addAll(list1, "a", "d", "b", "c");
		Collections.addAll(list2, "d", "e", "f", "g");
		System.out.println(Collections.disjoint(list1, list2)); 
		// 判断两个集合中的元素是否完全不同
	}
	@Test
	public void test5(){
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		Collections.addAll(list1, "a", "b", "c", "d", "e", "f");
		Collections.addAll(list2, "d", "e", "f");
		System.out.println(Collections.indexOfSubList(list1, list2)); 
		// 查找子集合出现的位置, 没找到则返回-1
	}
	@Test
	public void test6(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		Collections.fill(list, "未录入"); 
		// 使用新元素替换原有元素
		System.out.println(list);
	}
	@Test
	public void test7(){
		ArrayList<String> list = new ArrayList<String>();
		Collections.addAll(list, "a", "b", "c", "d", "e", "f", "d", "e", "f");
		Collections.replaceAll(list, "d", "x");
		System.out.println(list);
	}
	@Test
	public void test8(){
		ArrayList<String> list = new ArrayList<String>();
		Collections.addAll(list, "a", "b", "c", "d", "e", "f", "d", "e", "f");
		Collections.reverse(list);
		System.out.println(list);
	}
	@Test
	public void test9(){
		Person p2 = new Person("邱家恒", 23);
		Person p3 = new Person("马磊", 24);
		Person p1 = new Person("张金", 22);
		Person p4 = new Person("李毅", 25);
		Person p5 = new Person("王鑫", 25);

		ArrayList<Person> list = new ArrayList<Person>();

		Collections.addAll(list, p1, p2, p3, p4, p5);

		System.out.println(Collections.min(list)); // 使用自然顺序找到集合中最小的

		System.out.println(
				Collections.min(list, new Comparator<Person>() { 
					// 使用比较器顺序找到集合中最小的
					public int compare(Person o1, Person o2) {
						int nameGap = o1.getName().compareTo(o2.getName());
						return nameGap != 0 ? nameGap : o1.getAge() - o2.getAge();
					}
				}));

		System.out.println('张' + 0);
		System.out.println('马' + 0);
		System.out.println('邱' + 0);
		System.out.println('李' + 0);
		System.out.println('王' + 0);
		
		
	}
}
