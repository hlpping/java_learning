package com.summary.time.pre;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeFormat {
	
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
	
	/**
	 * 日期字符串转毫秒值
	 * @param date:yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static long getDateMillis(String date) throws ParseException{
		return dateFormat.parse(date).getTime();
	}
	
	/**
	 * 毫秒值转日期字符串
	 * @param millis :Long
	 * @return
	 */
	public static String getDate(long millis){
		return dateFormat.format(new Date(millis));
	}
	
	public static void main(String[] args) throws ParseException {
		
//		System.out.println(getDate(System.currentTimeMillis()));
		System.out.println(getDateMillis("2012-04-20"));
		
	}
}
