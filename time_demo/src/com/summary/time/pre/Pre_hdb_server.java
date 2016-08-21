package com.summary.time.pre;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Pre_hdb_server {
	/**
	 * 毫秒转日期
	 * @param str
	 * @return
	 */
	public static String getDateTimeByMillisecond(String str) {
		if(str !=null && str.length()>0){
//			Date date = new Date(Long.valueOf(str));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
			String time = format.format(Long.valueOf(str));
			return time;
		}else{
			return null;
		}
	}
	/**
	 * 时间字符串转毫秒
	 */
//	public static long string2TimeInMillis(String timeStr) throws ParseException{
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Calendar c1 = Calendar.getInstance();
//		c1.setTime(df.parse(timeStr));
//		return c1.getTimeInMillis();
//	}
	public static long string2TimeInMillis2(String timeStr) throws ParseException{
		DateFormat df =null;
		timeStr =timeStr.trim();
		
		if(timeStr.length() ==23){
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		}else if (timeStr.length() ==19 ){
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else if(timeStr.length() ==10){
			df = new SimpleDateFormat("yyyy-MM-dd");
		}
		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(df.parse(timeStr));
		return c1.getTimeInMillis();
	}
	public static boolean matchTime(String time) {
		String regex = "^13[0-9]{11}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(time);
		boolean b = m.matches();
		return b;
	}
	public static boolean matchDate(String time) {
		String regex = "^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))($|\\s([0-1]\\d|[2][0-3])\\:[0-5]\\d\\:[0-5]\\d($|\\s\\d{3}))";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(time);
		boolean b = m.matches();
		return b;
	}
	
	public void getMillis(String str){
		str=str.trim();
		//处理时间不全的字符串
		String mask = "2012-01-01 00:00:00 000";
		if(str.length() !=23 && str.length() !=19 && str.length() !=10){
			if(str.length()<23){
				str = str+mask.substring(str.length(),mask.length());
			}
		}
		try {
			String millisecond =""+string2TimeInMillis2(str);
		} catch (ParseException e) {
		//	result = "时间格式不正确";
		}
	}
	
	public void format() throws ParseException{
		String riqi ="2012-12-24";
		SimpleDateFormat riqi_format = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINESE) ;
		long start = riqi_format.parse(riqi).getTime();
		System.out.println(start);
		
	}
	
	@Test
	public void test() throws ParseException{
		format();
	}
}
