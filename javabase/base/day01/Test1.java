package base.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class Test1 {
	@Test
	public void helloworld(){
		System.out.println("大家好, 这是我的第一个Java程序");
	}
	
	@Test
	public void test(){
		System.out.println(0123);	// 一个数字以0开头, 程序就会把这个数字当做8进制数
		System.out.println(0xCA9);	// 在程序中十六进制数需要以0x开头
		
		System.out.println((char)(2+'A'));	// char是字符类型 Character
		System.out.println((char)67);
	}
	@Test
	//十进制转二进制
	public void decimalToBinary(){
		int x=98;
		StringBuffer sb=new StringBuffer();
		while(x>0){
			int y=x%2;
			sb.append(y);
			x=x/2;			
		}
		System.out.println(sb.reverse());
	}
	@Test
	//十进制转16进制
	public void decimalToHex(){
		int x=98;
		StringBuffer sb=new StringBuffer();
		while(x>0){
			int y=x%16;
			if(y<10){
				sb.append(y);				
			}else{
				sb.append((char)(y-10)+"A");
			}
			x=x/16;			
		}
		System.out.println(sb.reverse());		
	}
	@Test
	//十进制转二进制
	public void decimalToBinary2() throws IOException{
		System.out.println("请输入一个十进制的数:");	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();	// 读取一行
		int x = Integer.parseInt(line);	// 将字符串line转换为int值, 赋给x
		StringBuffer sb = new StringBuffer();
		while(x > 0){
			sb.append(x & 0x1);		// 相当于%2
			x = x >> 1;				// 相当于除2
		}
		System.out.println(sb.reverse());
	}
	@Test
	//十进制转16进制
	public void decimalToHex2(){
		int x = 198;								
		StringBuffer sb = new StringBuffer();	
		while(x > 0){							
			int y = x & 0xf;	// x % 16 和 x & 15 一样, 但一般人看到十六进制习惯理解为二进制.
			
			/*
			if(y < 10){					
				sb.append(y);						
			}else{					
				sb.append((char)(y-10+'A'));	
			}
			*/
			
			/*
			char[] arr = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F',};
			sb.append(arr[y]);
			*/
			
			sb.append(Character.forDigit(y, 16));	// 将y转换为16进制形式, 装入sb
			
			x = x >> 4;			// x / 16 和 右移4位一样
		}
		System.out.println(sb.reverse());	
	}
}
