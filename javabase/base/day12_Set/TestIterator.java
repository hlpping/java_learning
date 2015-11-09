package base.day12_Set;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class TestIterator {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new People("asd", 23));
		list.add(new People("sdfs", 21));
		list.add(new People("gfdg", 21));
		list.add(new People("gfg", 26));
		list.add(new People("hgf", 27));

//		iteration1(list);
//		iteration2(list);
//		iteration3(list);

//		remove1(list);
		remove2(list);
		iteration1(list);
	}

	// 1.由于List集合有序, 我们可以通过size()方法获取长度, 然后定义循环, 按顺序获取其中的每一个
	private static void iteration1(List list) {
		for(int i=0;i<list.size();i++){
			People p =(People) list.get(i);			
			System.out.println(p);
		}		
	}
	// 2.通过List的iterator()方法, 获取对应的迭代器, 使用其hasNext判断是否有下一个元素,
	// 如果有则使用next()方法获取下一个元素
	private static void iteration2(List list) {
		Iterator iterator=list.iterator();
		while(iterator.hasNext()){
			People p = (People) iterator.next(); // 获取下一个元素
			System.out.println(p);
		}		
	}
	// 3.这种方式是Vector类特有的, 其他类不能使用, JDK1.2之后已被淘汰
	private static void iteration3(Vector list) {
		Enumeration  e=list.elements();
		while(e.hasMoreElements()){
			People p = (People) e.nextElement(); // 获取下一个元素
			System.out.println(p);
		}
	}
	
	
	// for循环中删除, 需要将循环变量减1
	private static void remove1(ArrayList list) {
		for (int i = 0; i < list.size(); i++) {
			People p = (People) list.get(i);
			if (p.getAge() == 21)
				list.remove(i--);
		}		
	}
	// 使用迭代器时, 可以调用Iterator的remove()方法
	private static void remove2(ArrayList list) {
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			People p = (People) iter.next();
			if (p.getAge() == 21)
				iter.remove(); // 如果年龄是21, 就使用Iterator类的remove()方法删除
		}
	}
}
