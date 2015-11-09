package base.day13_Map.other;

import java.util.ArrayList;

public class WrapperClassDemo {
	public static void main(String[] args) {
		//		test1();
		//		test2();
		//		test3();
		//		test4();
		//		test5();

		//		test6();
		//		test7();
		//		test8();
		//		test9();
		//		test10();

		System.out.println(Character.forDigit(15, 16));
	}

	private static void test10() {
		String s = "123";
		Integer i = Integer.valueOf(s);
		System.out.println(i - 1);
	}

	private static void test9() {
		System.out.println(Integer.toBinaryString(98)); // 1100010
		System.out.println(Integer.toOctalString(98)); // 142
		System.out.println(Integer.toHexString(198)); // c6
	}

	private static void test8() {
		String s = "123";
		int i = Integer.parseInt(s); // 将字符串转换为数字
		System.out.println(i - 1);
	}

	private static void test7() {
		Integer i = 200;
		Integer j = 300;
		System.out.println(i.compareTo(j)); // 返回正数负数或0
	}

	private static void test6() {
		Integer i = 200;
		byte b = i.byteValue();
		System.out.println(b);

		// 00000000 00000000 00000000 11001000
		// 补码 11001000
		// 反码 11000111
		// 原码 00111000
		//     -56
	}

	private static void test5() {
		Integer integer1 = 1;
		Integer integer2 = 1;
		System.out.println(integer1 + integer2); // 自动拆箱, 自动装箱, 先拆成 1+1, 得到2, 再装成new Integer(2)
	}

	private static void test4() {
		Integer integer1 = 128;
		Integer integer2 = 128;
		System.out.println(integer1 == integer2); // 只缓冲一个字节 -128到127
	}

	private static void test3() {
		Integer integer1 = 98;
		Integer integer2 = new Integer(98);
		Integer integer3 = 98;
		System.out.println(integer1 == integer2); // 通过构造函数创建的, 不会放入缓冲区
		System.out.println(integer1 == integer3); // 直接写98, 这个98被放入了缓冲区
	}

	private static void test2() {
		System.out.println(123); // 自动装箱 System.out.println(new Integer(123));
	}

	private static void test1() {
		ArrayList<Integer> list = new ArrayList<Integer>(); // 集合中不能存放基本数据类型. 只能存对象
		list.add(123); // 自动装箱	list.add(new Integer(123));
		System.out.println(list.get(0));
	}
}
