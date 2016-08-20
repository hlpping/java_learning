package cn.test.other.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class Time {
	@Test
	public void test01() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currDate = sdf.format(new Date());
		
		System.out.println(currDate);
		int ic="2012-01-12".compareTo(currDate);
		int ic1="2012-01-13".compareTo(currDate);
		int ic2="2012-01-14".compareTo(currDate);
		System.out.println(ic);
		System.out.println(ic1);
		System.out.println(ic2);
		System.out.println(6*60*60*1000);
	}
	
	@Test
	public void test02() throws ParseException {
		
		string2TimeInMillis("2011-12-18 12:00:01");
		System.out.println(string2TimeInMillis("2011-12-19 08:00:01"));
		System.out.println(string2TimeInMillis("2011-12-19 09:00:01"));
		System.out.println(string2TimeInMillis("2011-12-19 09:10:01"));
		//1316880120289//
		//1324180801000
		//1324177201000
		//1324173601000
		
		//1324252801000
		//1324256401000
		//1324257001000
		
	}
	
	/**
	 * 时间字符串转毫秒
	 */
	public static long string2TimeInMillis(String timeStr)
			throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c1 = Calendar.getInstance();
		c1.setTime(df.parse(timeStr));
		long millis = c1.getTimeInMillis();
		return millis;
	}
	
	@Test
	public void test03() {
		
//		System.out.println(new Something().addInt(20));
		
//		System.out.println(Math.round(-11.5));
		
		String ss ="3,1,4,6,8";
		String[] str = ss.split(",");
		List<Integer> intList = new ArrayList<Integer>();
		for(int i=0;i<str.length;i++){
			intList.add(Integer.parseInt(str[i]));
		}
		Collections.sort(intList);
		
		String result ="";
		for(int j=0;j<intList.size();j++){
			 result += intList.get(j)+",";
		}
		result = result.substring(0,result.length()-1);
		
		System.out.println(result);
		
		
	}
	
}