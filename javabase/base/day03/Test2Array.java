package base.day03;

import org.junit.Test;

public class Test2Array {
	//关于默认值
	// 默认初始化为0
	// 所有引用数据类型默认值为null
	@Test
	public void test1() {
		// int[] arr ={5,67,8,23,45};
		String[] arr = { "abc", "def", "china" };

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	@Test
	public void test2() {
		int[] arr = new int[10];
		arr[0] = 100;
		arr[9] = 900;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	@Test
	public void test3() {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	@Test
	public void test4() {
		int[] arr1 = { 1, 2, 3, 4};
		arr1 = null; // 将arr赋值为null

		System.out.println(arr1[0]);
	}	
	
	@Test
	public void test5() {
	//多维数组
		/*
		int[][] arr = new int[][]{{1,2,3},{4,5},{6,7,8,9}};	// 多维数组, 数组中的每一个元素都是数组
		// System.out.println(arr.length);		// 数组的长度 
		// System.out.println(arr[0].length);
		// System.out.println(arr[1].length);
		// System.out.println(arr[2].length);
		
		for(int i=0; i<arr.length; i++){
			int[] smallArr = arr[i];
			for(int j=0; j<smallArr.length; j++){
				System.out.println(smallArr[j]);	
			}
		}
		*/
		
		/*
		int[][] arr = new int[3][3];	// 大数组有3个元素, 每个元素都是一个有3个元素的小数组
		for(int i=0; i<arr.length; i++){
			int[] smallArr = arr[i];
			for(int j=0; j<smallArr.length; j++){
				System.out.println(smallArr[j]);	
			}
		}
		*/
		
		/*
		int[][] arr = new int[3][];		// 定义一个数组, 由3个小数组组成, 小数组长度未指定
		
		arr[0] = new int[5];
		
		arr[0][3] = 100;
		
		arr[1] = new int[3];
		
		arr[1][0] = 200;
		
		for(int i=0; i<arr.length; i++){
			int[] smallArr = arr[i];
			for(int j=0; j<smallArr.length; j++){
				System.out.println(smallArr[j]);	
			}
		}
		*/
		
		
	}	
}
