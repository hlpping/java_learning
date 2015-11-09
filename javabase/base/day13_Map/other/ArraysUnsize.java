package base.day13_Map.other;

import org.junit.Test;

public class ArraysUnsize {
	@Test
	public void test1() {
		fun(1, 2, 3, 4, 5);
	}
	
	public  void fun(int i, int... arr) {
		System.out.println("i = " + i);
	}
	@Test
	public void test2() {
		print(1);
		print(2);
		print(1, 2);
		int[] arr = new int[] { 1, 2, 3 };
		print(arr);
		print();
	}

	public void print(int... arr) { // 这个形参可以接收0个到多个int值或者一个int数组, 将这些int值封装成一个数组
		System.out.println("arr的length是: " + arr.length);
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
}
