package base.day12_Set;

import java.util.ArrayList;
import java.util.List;

public class ListMethodTest {

	/*
	 * void add(int index, E element)  将一个对象E插入到当前集合的index位置
	 * boolean addAll(Collection<? extends E> c) 将集合c中的所有元素都添加到当前集合
	 * boolean addAll(int index, Collection<? extends E> c) 将集合c中所有元素都插入到当前集合的index位置
	 * void clear() 
	 * boolean contains(Object o) 
	 * boolean containsAll(Collection<?> c)  判断当前集合中是否包含c集合中的所有元素
	 * int indexOf(Object o) 
	 * int lastIndexOf(Object o) 
	 * boolean removeAll(Collection<?> c)  从当前集合中删除c集合中的所有元素
	 * boolean retainAll(Collection<?> c) 在当前集合中保留c集合中的元素, 其他删除 
	 * E set(int index, E element)  将对象E插入到index位置, 覆盖原有元素
	 * List<E> subList(int fromIndex, int toIndex) 从当前List中截取一个小List, 从formIndex处开始, 到toIndex结束
	 */
	public static void main(String[] args) {
		ArrayList<People> list = new ArrayList<People>();
		list.add(new People("李毅", 21));
		list.add(new People("邱家恒", 22));
		list.add(new People("仲衡", 20));
		list.add(new People("黄丹", 21));
		list.add(new People("张金", 21));
		list.add(new People("王青", 21)); // 添到最后

		//		test1(list);
		//		test2(list);
		//		test3(list);
		//		test4(list);
		//		test5(list);
		//		test6(list);
		//		test7(list);
		//		test8(list);
		//		test9(list);
		//		test10(list);
		//		test11(list);
		//		test12(list);
		//		test13(list);
	}

	private static void test13(ArrayList<People> list) {
		People[] arr = list.toArray(new People[0]);
		System.out.println(arr[0]);
		
	}

	private static void test12(ArrayList<People> list) {
		Object[] arr = list.toArray(); // 将集合转为数组
		System.out.println(arr[0]);
	}

	private static void test11(ArrayList<People> list) {
		List<People> subList = list.subList(1, 5);
		System.out.println(subList);
	}

	private static void test10(ArrayList<People> list) {
		list.set(4, new People("门雪飞", 18)); // 将4号位置替换成门雪飞
		//		list.add(4, new People("门雪飞", 18));	// 在4号位置插入门雪飞
		System.out.println(list);
	}

	private static void test9(ArrayList<People> list) {
		ArrayList<People> list1 = new ArrayList<People>();
		People p1 = new People("马磊", 24);
		People p2 = new People("门雪飞", 18);
		list1.add(p1);
		list1.add(p2);
		list1.add(new People("杨天赐", 20));

		list.add(p1);
		list.add(p2);

		//		list1.retainAll(list);		// 在list1中保留 list和list1的交集
		//		System.out.println(list1.size());

		list.retainAll(list1);
		System.out.println(list.size());
	}

	private static void test8(ArrayList<People> list) {
		ArrayList<People> list1 = new ArrayList<People>();
		People p1 = new People("马磊", 24);
		People p2 = new People("门雪飞", 18);
		list1.add(p1);
		list1.add(p2);
		list1.add(new People("杨天赐", 20));

		list.add(p1);
		list.add(p2);

		//		list.removeAll(list1); // 在list中删除list1中包含的所有元素
		//		System.out.println(list.size());

		list1.removeAll(list);
		System.out.println(list1.size());
	}

	private static void test7(ArrayList<People> list) {
		People p = new People("马磊", 24);
		list.add(p);
		list.add(2, p);
		System.out.println(list.indexOf(p)); // 2
		System.out.println(list.lastIndexOf(p)); // 7
	}

	private static void test6(ArrayList<People> list) {
		ArrayList<People> list1 = new ArrayList<People>();
		People p1 = new People("马磊", 24);
		People p2 = new People("门雪飞", 18);
		list1.add(p1);
		list1.add(p2);
		//		list1.add(new People("杨天赐", 20));

		list.add(p1);
		list.add(p2);

		System.out.println(list.containsAll(list1)); // 判断list1中的元素是否在list中全部包含
	}

	private static void test5(ArrayList<People> list) {
		System.out.println(list.contains(new People("邱家恒", 22))); // 因为不是同一个对象, 地址不同

		People p = new People("马磊", 24);
		list.add(p);
		System.out.println(list.contains(p)); // 如果地址相同, 才是同一个对象
	}

	private static void test4(ArrayList<People> list) {
		list.clear(); // 清除所有元素
		System.out.println(list);
		System.out.println(list.size());
	}

	private static void test3(ArrayList<People> list) {
		ArrayList<People> list1 = new ArrayList<People>();
		list1.add(new People("王鑫", 21));
		list1.add(new People("门雪飞", 18));

		list.addAll(2, list1);

		System.out.println(list);
	}

	private static void test2(ArrayList<People> list) {
		ArrayList<People> list1 = new ArrayList<People>();
		list1.add(new People("王鑫", 21));
		list1.add(new People("门雪飞", 18));

		list.addAll(list1); // 将list1中的对象添加到list中

		System.out.println(list);
	}

	private static void test1(ArrayList<People> list) {
		list.add(1, new People("张磊", 23)); // 将张磊添加到1号位置, 后面的元素全部后移
		System.out.println(list);
	}

}
