package base.day13_Map.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateDemo {
	public static void main(String[] args) throws Exception {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
//		test1();
		test2();
//		test3();
		
	}
	private static void test1() {
		Date date = new Date(); // 创建一个Date对象, 代表当前时间.
		System.out.println(date);

		System.out.println(date.toLocaleString()); // 转换为本地时间, 已过时

		long time = date.getTime(); // 获取从1970年1月1日0时, 到创建date时经过了多少毫秒.
		System.out.println(time);

		Date date1 = new Date(time);
		System.out.println(date1);
	}
	private static void test2() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = simpleDateFormat.format(date); // 将日期转化为字符串
		System.out.println(s);
	}
	
	private static void test3() throws Exception {
		String str ="2011-05-06 16:41:00";
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date =format.parse(str);
		System.out.println(date);
	}
}
