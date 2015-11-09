package base.day08_exception;

import java.io.FileNotFoundException;

public class ExceptionDemo01 {
	public static void main(String[] args) {
//		div(10,0);
		
//		int[] arr = new int[]{1,2,3};
//		arr =null;
//		print(arr,5);
		
		int i=1;
		try{
			if(i%2==1)
				throw new FileNotFoundException();
		}catch(FileNotFoundException e){
			System.out.println("出异常了, 找不到文件");
		}
		System.out.println("程序运行结束");		
	}
	public static void div(int i,int j){
		System.out.println(i/j);
	}
	public static void print(int[] arr,int index){
		System.out.println(arr[index]);
	}
}