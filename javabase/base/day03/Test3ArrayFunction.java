package base.day03;

import java.util.Arrays;

import org.junit.Test;

public class Test3ArrayFunction {
	@Test
	public void test1() {
		int[] arr = new int[]{123,321,12345,23,4,5,7,87,43};	
//		System.out.println(arr);
//		System.out.println(toString(arr));
		
//		exchange(arr, 0, 3);
//		System.out.println(toString(arr));
		
//		System.out.println(findMax(arr));
		
//		reverse(arr);
//		System.out.println(toString(arr));
	}	

	/*
	a).定义一个方法, 通过形参接收一个int数组, 用以下形式打印出数组中的所有元素. {123,321,12345,23,4,5,7,87,43}
		思路: 
			定义一个StringBuffer用来存储结果.
			开始时向其中添加一个{
			遍历数组, 将每一个元素都添加到StringBuffer中, 每添加一个元素, 都多添一个逗号
			当所有元素都添加完毕之后, 删除最后一个逗号
			再添加}
			最后, 将StringBuffer中的内容打印
	*/
	public String toString(int[] arr){
		StringBuffer sb =new StringBuffer();
		sb.append("{");
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]);
			sb.append(",");			
		}
		sb.deleteCharAt(sb.length()-1);		
		sb.append("}");
		return sb.toString();
	}
	
	public void exchange(int[] arr,int a,int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;		
	}
	public int findMax(int[] arr){
		int max=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}		
		return max;
	}
	
	public void reverse(int[] arr){
		for(int i=0;i<arr.length/2;i++){
			exchange(arr, i, arr.length-i-1);
		}		
	}
	
	@Test
	public void test2() {
		int[] arr = new int[]{123,321,12345,23,4,5,7,87,43};
		Arrays.sort(arr);		// 将数组中的元素排序
		System.out.println(Arrays.toString(arr));	// 将数组转成字符串			
	}
	@Test
	public void test3() {
		int[] arr1 = new int[]{100,200,300,400,500,600,700,800};
		int[] arr2 = new int[8];
		System.arraycopy(arr1,2,arr2,3,3);		// lang包中的类, 不需要导包
		System.out.println(Arrays.toString(arr2));		
	}
}
