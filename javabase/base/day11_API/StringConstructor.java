package base.day11_API;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.junit.Test;

public class StringConstructor {
	
	@Test
	public void test(){
		
	}
	@Test
	public void test1(){
		String s="中文";
		byte[] arr =s.getBytes();	
		// 将字符串编码成二进制, 使用默认码表, GBK	
		System.out.println(Arrays.toString(arr));
	}
	@Test
	public void test2(){
		byte[] arr = new byte[] { -13, 81 };
		String s = new String(arr); // 将二进制解码成字符串, 使用默认码表, GBK
		System.out.println(s);
	}
	@Test
	public void test3() throws UnsupportedEncodingException{
		String s = "驫";
		byte[] arr = s.getBytes("UTF-8"); // 将字符串编码成二进制, 使用UTF-8码表
		System.out.println(Arrays.toString(arr));
	}
	@Test
	public void test4() throws UnsupportedEncodingException{
		byte[] arr = new byte[] { -23, -87, -85 };
		String s = new String(arr, "UTF-8"); // 将二进制解码成字符串, 使用UTF-8码表
		System.out.println(s);
	}
	@Test
	public void test5() throws UnsupportedEncodingException{
		byte[] arr = new byte[] { -42, -48, -50, -60 };
		String s = new String(arr, 2, 2, "GBK");
		System.out.println(s);
	}
	@Test
	public void test6(){
		char c1 = '中';
		char c2 = '文';
		char[] arr = new char[] { c1, c2 };
		String s = new String(arr);
		System.out.println(s);

		String s1 = new String(arr, 1, 1);
		System.out.println(s1);
	}
	@Test
	public void test7(){
		StringBuffer sb = new StringBuffer();
		sb.append("a");
		sb.append("b");
		sb.append("c");
		String s = sb.toString();
		String s1 = new String(sb);
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s == s1);
	}
	@Test
	public void test8(){
		String s = "abc";
		System.out.println(s.charAt(0));
		System.out.println(s.charAt(1));
		System.out.println(s.charAt(2));
		System.out.println(s.charAt(3));
	}
	
	
}
