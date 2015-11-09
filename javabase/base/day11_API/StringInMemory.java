package base.day11_API;

import org.junit.Test;

public class StringInMemory {
	@Test
	public void test9(){
		String s1 = "abc";
		String s2 = new String("abc");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2); // 地址不同
	}
	@Test
	public void test10(){
		String s1 = "abc"; // 字符串缓冲区
		String s2 = "abc";
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2); // 地址相同

		s1 = "def"; // 由于字符串是常量, 存储后不会被改变, 这里改变值是指向新的地址
		System.out.println(s1);
		System.out.println(s2);
	}
	@Test
	public void test11(){
		String s1 = new String("abc"); // 使用构造函数创建, 是直接在堆内存中创建, 再维护缓冲区
		String s2 = "abc";
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
	@Test
	public void test12(){
		String s1 = "abc";
		String s2 = "a" + "b" + "c"; // 这里没有进行字符串相加, 在编译的时候直接转成了 String s2 = "abc";
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
	@Test
	public void test13(){
		String s1 = "abc";
		String s2 = "a";
		String s3 = "b";
		String s4 = "c";
		String s5 = s2 + s3 + s4; // 字符串相加是通过StringBuffer的append方法实现的.
		/*
		 * StringBuffer sb = new StringBuffer();
		 * sb.append(s2);
		 * sb.append(s3);
		 * sb.append(s4);
		 * String s5 = sb.toString();	// 由方法返回的字符串, 不会维护缓冲区.
		 */
		System.out.println(s1);
		System.out.println(s5);
		System.out.println(s1 == s5);
	}
	@Test
	public void test14(){
		String s1 = "abc";
		String s2 = "ABC";
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
		s2 = s2.toLowerCase(); // 将字符串转换为小写
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2); // s2是由方法返回的字符串, 不引用缓冲区
	}
}
