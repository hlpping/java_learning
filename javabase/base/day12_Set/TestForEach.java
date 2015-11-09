package base.day12_Set;

import java.util.ArrayList;
import java.util.Iterator;

public class TestForEach {
	public static void main(String[] args) {
		ArrayList<People> list = new ArrayList<People>();
		list.add(new People("asd", 23));
		list.add(new People("sdfs", 21));
		list.add(new People("gfdg", 21));
		list.add(new People("gfg", 26));
		list.add(new People("hgf", 27));
		
		
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

		System.out.println();

		Iterator<People> iter = list.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());

		System.out.println();

		for (People p : list)
			System.out.println(p); // 遍历list集合, 在循环的每一次执行时, 将list中的每一个元素赋值给p
		
		
	}
}
