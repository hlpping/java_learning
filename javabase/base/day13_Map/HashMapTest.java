package base.day13_Map;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<Person, String> map = new HashMap<Person, String>();
		map.put(new Person("zs", 20), "A"); // Entry
		map.put(new Person("ls", 22), "B");
		map.put(new Person("ww", 21), "A");
		map.put(new Person("zl", 21), "C"); // 存储的时候, 会调用key对象的hashCode和equals
		map.put(new Person("zl", 21), "C");
		map.put(new Person("zl", 21), "A"); 
		// Map集合重复元素是后来的覆盖原有的, Set集合重复元素不存入集合
		
//		System.out.println(map);
//		iteration1(map);
		iteration2(map);		
	}

	private static void iteration1(HashMap<Person, String> map) {
		 // 获取Map集合中所有Entry(键值对,记录)组成的一个Set
		Set<Entry<Person, String>>  entrySet = map.entrySet();
		for(Entry<Person, String> e: entrySet){
			System.out.println(e.getKey() + " = " + e.getValue()); 
		}
	}
	private static void iteration2(HashMap<Person, String> map) {
		Set<Person> keySet = map.keySet(); // 获取Map集合中的所有key组成的一个Set
		for (Person p : keySet) { // 遍历这个Set, 就可以得到Map的每一个key
			System.out.println(p); // p就是每一个key
			System.out.println(map.get(p)); // 获取到了key, 就可以从Map中根据key获取value
		}	
	}
}
