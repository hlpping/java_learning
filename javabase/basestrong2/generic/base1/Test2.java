package basestrong2.generic.base1;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Test2 {
	
	@Test
	public void test1(){
		Integer arr[] =new Integer[3];
		arr[0]=0;
		arr[1]=1;
		arr[2]=2;
		
		swap(arr,0,2);
		List list =Arrays.asList(arr);
		System.out.println(list);
	}
	//元素的交换
	public void swap(Integer arr[],int p,int q){
		Integer temp =arr[p];
		arr[p]=arr[q];
		arr[q]=temp;
	}
	
	@Test
	public void test2(){
		Integer arr[] =new Integer[3];
		arr[0]=0;
		arr[1]=1;
		arr[2]=2;
		
		swaps(arr,0,2);
		List list =Arrays.asList(arr);
		System.out.println(list);
	}
	
	//编写一个泛型方法 实现数组元素的交换
	public <T> void swaps(T arr[],int p,int q){
		T temp =arr[p];
		arr[p]=arr[q];
		arr[q]=temp;
	}
	
	
	@Test
	public void test3(){
		Integer arr[] =new Integer[8];
		arr[0]=0;
		arr[1]=1;
		arr[2]=2;
		arr[3]=3;
		arr[4]=4;
		arr[5]=5;
		arr[6]=6;
		arr[7]=7;
		
		reverse(arr);
		System.out.println(Arrays.asList(arr));
	}
	
	//编写一个泛形方法，接收一个任意数组，并颠倒数组中的所有元素
	public <T> void reverse (T arr[]){
		int start =0;
		int end =arr.length-1;
		
		while(true){
			if(start>=end){
				break;
			}
			T temp =arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			
			start++;
			end--;
		}
		
	}
	
	
}
