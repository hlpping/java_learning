package com.summary.time.pre;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat2 {
	
	public static final String DATE = "yyyy-MM-dd";
	public static final String HOUR = "yyyy-MM-dd HH";
	public static final String MINUTE = "yyyy-MM-dd HH:mm";
	public static final String SECOND = "yyyy-MM-dd HH:mm:ss";
	public static final String millisecond = "yyyy-MM-dd HH-mm-ss SSS";
	
	/**
	 * 日期字符串转毫秒值
	 * @param date 时间
	 * @param format 时间的格式
	 * @return
	 * @throws ParseException
	 */
	public static long getDateMillis(String date,String format) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat(format) ;
		return dateFormat.parse(date).getTime();
	}

	/**
	 * 毫秒值转日期字符串
	 * @param millis 时间的毫秒
	 * @param format 时间格式
	 * @return
	 */
	public static String getDate(long millis,String format){
		SimpleDateFormat dateFormat = new SimpleDateFormat(format) ;
		return dateFormat.format(new Date(millis));
	}
	
	public static void main(String[] args) throws ParseException {
		
//		System.out.println(getDateMillis("2012-04-20",TimeFormat2.DATE));
//		System.out.println(getDateMillis("2012-04-20 12",TimeFormat2.HOUR));
		
		System.out.println(getDate(System.currentTimeMillis(),TimeFormat2.millisecond));
		
		
	}
}
