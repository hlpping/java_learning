package com.summary.time.pre;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pre_state_server {
	/**dd/MMMM/yyyy:HH:mm:ss Z*/
	public static final String format1="dd/MMMM/yyyy:HH:mm:ss Z";
	/**yyyy MMM dd HH:mm*/
	public static final String format2="yyyy MMM dd HH:mm";
	/**MMM dd HH:mm yyyy*/
	public static final String format3="MMM dd HH:mm yyyy";
	/**MMM dd yyyy*/
	public static final String format4="MMM dd yyyy";
	/**yyyy-MM-dd HH:mm:ss*/
	public static final String format5="yyyy-MM-dd HH:mm:ss";
	/**yyyy-MM-dd*/
	public static final String format6="yyyy-MM-dd";
	
	/**MMM dd HH:mm*/
	public static final String format7="MMM dd HH:mm";
	
	/**
	 * 处理没有年份的时间问题
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static long getLongtime(String str) throws ParseException{
		int year=Calendar.getInstance().get(Calendar.YEAR);
		long now =System.currentTimeMillis();
		String strYear = year +" "+str;
		long value =getTimeMills(strYear,format2);
		
		if(value>now){
			strYear = year-1 +" "+str;
			value = getTimeMills(strYear,format2);
		}
		return value;
	}
	/**
	 * 时间字符串转毫秒
	 * @param timeStr
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static long getTimeMills(String timeStr,String format) throws ParseException {
//		timeStr = timeStr.substring(1, timeStr.length() - 1).trim();
		DateFormat df = new SimpleDateFormat(format,Locale.US);
		Calendar c1 = Calendar.getInstance();
		c1.setTime(df.parse(timeStr));
		return c1.getTimeInMillis();
	}
	/**
	 * 时间字符串转毫秒<br>
	 * @param timeStr 参数字符串形如: 16/三月/2012:09:17:39 +0800
	 * @return long
	 * @throws ParseException
	 */
	public static long getTimeMillsCN(String timeStr) throws ParseException {
		String month = timeStr.substring(
				timeStr.indexOf("/")+1,timeStr.indexOf("/",timeStr.indexOf("/")+1));
		if("一月".equals(month)){
			month = "Jan";
		}else if("二月".equals(month)){
			month = "Feb";
		}else if("三月".equals(month)){
			month = "Mar";
		}else if("四月".equals(month)){
			month = "Apr";
		}else if("五月".equals(month)){
			month = "May";
		}else if("六月".equals(month)){
			month = "Jun";
		}else if("七月".equals(month)){
			month = "Jul";
		}else if("八月".equals(month)){
			month = "Aug";
		}else if("九月".equals(month)){
			month = "Sep";
		}else if("十月".equals(month)){
			month = "Oct";
		}else if("十一月".equals(month)){
			month = "Nov";
		}else if("十二月".equals(month)){
			month = "Dec";
		}
		timeStr = timeStr.substring(0,timeStr.indexOf("/")+1) +month + timeStr.substring(
					timeStr.indexOf("/",timeStr.indexOf("/")+1),timeStr.length());
		
		return getTimeMills(timeStr,format1);
	}

	/**
	 * 毫秒转日期
	 * @param num 参数是长整形
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getDate(long num) {
			return new SimpleDateFormat(format5).format(num);
	}
	
	/**
	 * 获得两小时前的时间 <br>
	 * 例: 当前时间是14:20,则缺省展示12:00-12:20的记录 
	 * @return "yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm:ss"
	 */
	public String[] get2HourAgo(){
		long mill = System.currentTimeMillis();
		long min10 = 10*60*1000;
		long start = (mill-2*80*60*1000)/min10*min10;
		long end =  (mill-2*60*60*1000)/min10*min10;
		String[] timeArr ={getDate(start) ,  getDate(end)};
		return timeArr;
	}
	
	/**
	 * 获得当前日期前的任何一天 <br>
	 * 例:-1,前一天 ;-10,前十天;10 十天后
	 * @param num
	 * @return "yyyy-MM-dd"
	 */
	public static String getAnyDayFromToday(int num) {
		SimpleDateFormat format = new SimpleDateFormat(format6);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, num);
		return format.format(c.getTime());
	}
	/**
	 *  判断时间是否符合正则表达式 May 17  2011
	 * @param str
	 * @return
	 */
	public static boolean testRegexDate2(String str) {
		String regex = "^[A-Z][a-z]{2}\\s[\\s|123][0-9]\\s\\s[0-9]{4}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		boolean b = m.matches();
		return b;
	}
	
	/**
	 * 判断时间是否符合正则表达式 Nov 5 09:59
	 */
	public static boolean testRegexDate1(String str) {
		String regex = "^[A-Z][a-z]{2}\\s[\\s|123][0-9]\\s[0-5][0-9]\\:[0-5][0-9]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		boolean b = m.matches();
		return b;
	}
	

}
