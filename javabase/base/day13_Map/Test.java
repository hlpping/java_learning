package base.day13_Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		HashMap<Person, String> map = new HashMap<Person, String>();
		map.put(new Person("zs", 20), "A");
		map.put(new Person("ls", 22), "B");
		map.put(new Person("ww", 21), "A");
		map.put(new Person("zl", 21), "C");
		map.put(new Person("zl", 21), "C");
		map.put(new Person("zl", 21), "A"); 
		// Map中存储重复对象是覆盖原有记录, 
		// Set中存储重复对象时是不存.

//				test1(map);
//				test2(map);
//				test3(map);
//				test4(map);
//				test5(map);
				test6(map);		
	}
	
	private static void test1(HashMap<Person, String> map) {
		System.out.println(map.size());
		map.clear();
		System.out.println(map.size());
	}
	private static void test2(HashMap<Person, String> map) {
		System.out.println(map.containsKey(new Person("zs", 20))); // 判断map中是否有指定的key
		System.out.println(map.containsKey(new Person("zs", 30)));
	}
	
	private static void test3(HashMap<Person, String> map) {
		System.out.println(map.containsValue("A")); // 判断map中是否有指定的value
		System.out.println(map.containsValue("B"));
		System.out.println(map.containsValue("C")); // C由于被覆盖了, 所以没有
	}
	
	private static void test4(HashMap<Person, String> map) {
		HashMap<Person, String> newMap = new HashMap<Person, String>();
		newMap.put(new Person("zs", 20), "A");
		newMap.put(new Person("ls", 22), "B");
		newMap.put(new Person("ww", 21), "A");
		newMap.put(new Person("zl", 21), "C");

		map.putAll(newMap); // 将newMap中的所有元素添加到map中

		for (Person p : map.keySet())
			System.out.println(p + " = " + map.get(p));
	}
	private static void test5(HashMap<Person, String> map) {
		map.remove(new Person("zs", 20)); // 删除指定key对应的记录
		for (Person p : map.keySet())
			System.out.println(p + " = " + map.get(p));
	}
	private static void test6(HashMap<Person, String> map) {
		// 获取所有key, 可以使用keySet(). 那有没有valueSet()
		Collection<String> c = map.values();

		// 1.Iterator	// 添加多行注释 ctrl+shift+/  取消多行注释 ctrl+shift+\
		/*Iterator<String> iter = c.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());*/

		for (Iterator<String> iter = c.iterator(); iter.hasNext();)
			System.out.println(iter.next());

		System.out.println();

		// 2.增强for循环
		for (String s : c)
			System.out.println(s);

		// 普通for循环只能作用于List, 因为List是有序的, 可以按序号获取, 而Collection下的Set集合无序, 不能根据序号获取
		// Enumeration只能用于Vector
	}
}
