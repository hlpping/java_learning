package cn.test.datastructure.chap02;

import org.junit.Test;

public class App01 {
	
	@Test
	public void test01(){
		int arr[] = new int[]{};
		System.out.println(arr.length);
		
		int[] arr2 = new int[]{};
		System.out.println(arr2.length);
		
	}
	
	@Test
	public void test02(){
		int arr[] = new int[10];
		System.out.println(arr.length);
//		arr[11]=20;	//java.lang.ArrayIndexOutOfBoundsException
//		System.out.println(arr[11]);
		
		each(arr);

	}

	private void each(int[] arr) {
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" , ");
		}
	}
	
	private void each(java.io.Serializable[] arr) {
		System.out.println("java.io.Serializable");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
	
	@Test
	public void test03(){
		Integer arr[] = new Integer[10];
		System.out.println(arr.length);
		each(arr);
	}
	
	@Test
	public void test04(){
		
		
	}
	
	@Test
	public void test05(){
		
		
	}
	
	@Test
	public void test06(){
		
		
	}
	
	@Test
	public void test07(){
		
		
	}
	
	@Test
	public void test08(){
		
		
	}
	
	@Test
	public void test09(){
		
		
	}
	
	@Test
	public void test10(){
		
		
	}
	
	@Test
	public void test11(){
		
		
	}
	
}
