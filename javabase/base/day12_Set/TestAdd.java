package base.day12_Set;

import java.util.ArrayList;

public class TestAdd {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList list =new ArrayList();
		list.add(new People("asd",23));
		list.add(new People("sdfs",24));
		list.add(new People("gfdg",25));
		list.add(new People("gfg",26));
		list.add(new People("hgf",27));
		list.add("abc");
		list.add("abc");
		list.add(123);
		list.add(123);
		list.add(true);
		
		System.out.println(list.size());
		System.out.println(list.get(6));
		System.out.println(list.get(5));

		System.out.println(list.get(6) == list.get(5));
		
		
		
	}
}
