package com.ok;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {
	
	static SimpleDateFormat dateFormat ;

	/**
	 * 根据时间字符串获得时间毫秒值
	 * @param date		String:时间字符串
	 * @param format 	String:输入的时间的类型
	 * @return
	 * @throws ParseException
	 */
	public static long getDateMillis(String date ,String format) throws ParseException{
		dateFormat = new SimpleDateFormat(format.trim()) ;
		return dateFormat.parse(date).getTime();
	}
	
	/**
	 * 时间的毫秒转化为时间字符串
	 * @param millis 	Long:毫秒
	 * @param format	String:输出的时间的类型
	 * @return
	 */
	public static String getDate(long millis ,String format){
		dateFormat = new SimpleDateFormat(format.trim()) ;
		return dateFormat.format(new Date(millis));
	}
	
	public static void main(String[] args) throws ParseException {
		
		System.out.println(getDateMillis("2012-04-20 01:00:01","yyyy-MM-dd HH:mm:ss"));
		
		System.out.println(getDate(System.currentTimeMillis(),"yyyy-MM-dd"));
	}
}
