package base.day13_Map.other;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import base.day13_Map.Person;

public class ArraysTest {
	
	@Test
	public void test9() {
		int[] arr = new int[] { 12, 3, 56, 57, 8679, 9, 0, 67, 3, 21, 123, 56, 010 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr)); // 打印的时候只显示十进制

		System.out.println(10);
		System.out.println(010);
		System.out.println(0x10);
	}
	@Test
	public void test8() {
		int[] arr = new int[10];
		System.out.println(Arrays.toString(arr));
		Arrays.fill(arr, -1);
		System.out.println(Arrays.toString(arr));
	}
	@Test
	public void test7() {
		Person[] arr1 = new Person[] { new Person("zs", 20), new Person("ls", 21), new Person("ww", 20) };
		System.out.println(Arrays.deepToString(arr1));
		System.out.println(Arrays.toString(arr1));

		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(Arrays.toString(arr));
	}
	@Test
	public void test6() {
		Person[] arr1 = new Person[] { new Person("zs", 20), new Person("ls", 21), new Person("ww", 20) };
		Person[] arr2 = new Person[] { new Person("zs", 20), new Person("ww", 20), new Person("ls", 21) };
		System.out.println(arr1.equals(arr2));
		System.out.println(Arrays.deepEquals(arr1, arr2)); 
		// 比较两个数组中的每一个对象是否相同.
	}
	@Test
	public void test5() {
		int[] arr1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int[] arr2 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(arr1.equals(arr2)); // 比较两个数组是否相同
		System.out.println(Arrays.equals(arr1, arr2)); // 比较两个数组每一个元素是否相同
	}
	@Test
	public void test4() {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int[] newArr = Arrays.copyOfRange(arr, 1, 6);
		System.out.println(Arrays.toString(newArr));
	}
	@Test
	public void test3() {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int[] newArr = Arrays.copyOf(arr, 5); // 从arr中拷贝5个到新数组
		System.out.println(Arrays.toString(newArr));
	}
	@Test
	public void test2() {
		int[] arr = new int[] { 100, 150, 210, 251, 300, 350, 400, 450, 500 }; // 二分法查找只能找有顺序的数组
		System.out.println(Arrays.binarySearch(arr, 450));
		System.out.println(Arrays.binarySearch(arr, 100));

		System.out.println(Arrays.binarySearch(arr, 800)); // 返回负数就代表没找到, 但是只返回-1信息量不够, 还告诉我们如果有, 应该出现在什么位置
		System.out.println(Arrays.binarySearch(arr, 50));
		System.out.println(Arrays.binarySearch(arr, 200));
	}
	@Test
	public void test1() {
		Person p1 = new Person("张金", 22);
		Person p2 = new Person("邱家恒", 23);
		Person p3 = new Person("马磊", 24);
		Person p4 = new Person("李毅", 25);

		List<Person> list = Arrays.asList(p1, p2, p3, p4); // 创建一个List, 将传入的对象装入List
		for (Person p : list) {
			System.out.println(p);
		}
	}
}
