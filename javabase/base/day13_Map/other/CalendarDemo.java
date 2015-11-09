package base.day13_Map.other;

import java.util.Calendar;
import java.util.TimeZone;

import org.junit.Test;

public class CalendarDemo {
	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
//		printCanlendar();
//		testLeapYear();
//		testApi();
		countTime(20);
	}
	@Test
	public static void printCanlendar(){
		Calendar c=Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1; // 月份是从0开始
		int date = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR_OF_DAY); // HOUR是十二进制小时, HOUR_OF_DAY是二十四进制小时
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		int day = c.get(Calendar.DAY_OF_WEEK) - 1;
		String[] dayArr = new String[] { "日", "一", "二", "三", "四", "五", "六" };
		String time ="当前时间: " + year + "年" + month + "月" + date + "日 " + hour + "时" + minute + "分" + second + "秒 星期" + dayArr[day];
		
		System.out.println(time);
	}	
	// (年数可以整除4, 但不能整除100) 或者 年数可以整除400
	// (year % 4 == 0 && year % 100 != 0) || year % 400 == 0
	// 2000, 2100, 2012
	// 将日历翻到指定年的3月1日, 再向前翻1天, 看这天是几号
	public static boolean isLeapYear(int year){
		Calendar c=Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, 2);
		c.set(Calendar.DATE, 1);
		c.add(Calendar.DATE, -1);
		Boolean result=c.get(Calendar.DATE)==29;		
		
		return result;
	}
	@Test
	public static void testLeapYear(){
		System.out.println(isLeapYear(2012));
		System.out.println(isLeapYear(2000));
		System.out.println(isLeapYear(2100));
		System.out.println(isLeapYear(2011));
		
	}
	@Test
	public static void testApi(){
		Calendar c=Calendar.getInstance();
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));
		
		c.add(Calendar.DATE, 100);
		c.set(Calendar.YEAR, 2000);
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH)+" "+c.get(Calendar.DATE));		
	}
	@Test
	public static void countTime(int days){
		// 有一个项目, 需要20天来完成, 周末双休, 从今天开始干, 计算什么时候完工.
		Calendar c=Calendar.getInstance();
		for(int i=0;i<days;i++){
			if(c.get(Calendar.DAY_OF_WEEK)==1 ||c.get(Calendar.DAY_OF_WEEK)==7)
				days++;			
			c.add(Calendar.DATE,1);
		}
		System.out.println(c.getTime());
	}
}
