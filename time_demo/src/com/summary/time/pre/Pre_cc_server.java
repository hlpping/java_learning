package com.summary.time.pre;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pre_cc_server {
	
	public static String testTime(String time) {
		if (time.trim().length() == 0) {
			time = getTodayTime();
		}
		if (time.trim().length() == 10) {
			time = time + " 09:00:00";
		}
		if (time.trim().length() == 13) {
			time = time + ":00:00";
		}
		if (time.trim().length() == 16) {
			time = time + ":00";
		}
		return time;
	}

	// 今天早上九点
	public static String getTodayTime() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		String strMonth=aboutZero(month);
		String strDate = aboutZero(date);
		if (date < 10 && date > 0) {
			strDate = "0" + date;
		} else {
			strDate = date + "";
		}
		String dayTime = "" + year + "-" + strMonth + "-" + strDate + " 09:00:00";
		return dayTime;
	}

	// 获得前一小时的时间
	public static String getForeHour() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR_OF_DAY) - 1;
		
		String strMonth=aboutZero(month);
		String strDate = aboutZero(date);
		String strHour=aboutZero(hour);
		
		String dayTime = "" + year + "-" + strMonth + "-" + strDate + " " + strHour
				+ ":00:00";
		return dayTime;
	}

	// 获得现在的时间
	public static String getNow() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minite = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);

		String strMonth=aboutZero(month);
		String strDate = aboutZero(date);
		String strHour=aboutZero(hour);
		String strMinite = aboutZero(minite);
		String strSecond = aboutZero(second);
		
		String dayTime = "" + year + "-" + strMonth + "-" + strDate + " " + strHour
				+ ":" + strMinite + ":" + strSecond;
		return dayTime;
	}
	/**
	 * 解决个位数字补0的操作
	 * @param time
	 * @return
	 */
	private static String aboutZero(int time){
		String strTemp=null;
		if (time < 10 && time >= 0) {
			strTemp = "0" + time;
		} else {
			strTemp = time + "";
		}
		return strTemp;
	}

	// 根据文件的时间获取开始时间
	public static String getStart(String s) {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		int year = c.get(Calendar.YEAR);
		String month = null;
		String str = s.substring(0, s.indexOf(" ")).trim();

		if (str.equals("Jan")) {
			month = "01";
		} else if (str.equals("Feb")) {
			month = "02";
		} else if (str.equals("Mar")) {
			month = "03";
		} else if (str.equals("Apr")) {
			month = "04";
		} else if (str.equals("May")) {
			month = "05";
		} else if (str.equals("June")) {
			month = "06";
		} else if (str.equals("July")) {
			month = "07";
		} else if (str.equals("Aug")) {
			month = "08";
		} else if (str.equals("Sept")) {
			month = "09";
		} else if (str.equals("Oct")) {
			month = "10";
		} else if (str.equals("Nov")) {
			month = "11";
		} else if (str.equals("Dec")) {
			month = "12";
		}
		String date = s.substring(s.indexOf(" "), s.lastIndexOf(" ")).trim();
		if (Integer.parseInt(date) < 10) {
			date = "0" + date;
		}
		String hour = s.substring(s.lastIndexOf(" "), s.lastIndexOf(" ") + 3)
				.trim();

		String result1 = year + "-" + month + "-" + date + " " + hour
				+ ":00:00";

		return result1;
	}

	// 根据文件的时间获取结束时间
	public static String getEnd(String s) {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		int year = c.get(Calendar.YEAR);
		String month = null;
		String str = s.substring(0, s.indexOf(" ")).trim();

		if (str.equals("Jan")) {
			month = "01";
		} else if (str.equals("Feb")) {
			month = "02";
		} else if (str.equals("Mar")) {
			month = "03";
		} else if (str.equals("Apr")) {
			month = "04";
		} else if (str.equals("May")) {
			month = "05";
		} else if (str.equals("June")) {
			month = "06";
		} else if (str.equals("July")) {
			month = "07";
		} else if (str.equals("Aug")) {
			month = "08";
		} else if (str.equals("Sept")) {
			month = "09";
		} else if (str.equals("Oct")) {
			month = "10";
		} else if (str.equals("Nov")) {
			month = "11";
		} else if (str.equals("Dec")) {
			month = "12";
		}
		String date = s.substring(s.indexOf(" "), s.lastIndexOf(" ")).trim();
		if (Integer.parseInt(date) < 10) {
			date = "0" + date;
		}
		String hour = s.substring(s.lastIndexOf(" "), s.lastIndexOf(" ") + 3)
				.trim();
		String minite = s.substring(s.lastIndexOf(" ") + 4,
				s.lastIndexOf(" ") + 6).trim();

		String result2 = year + "-" + month + "-" + date + " " + hour + ":"
				+ minite + ":59";

		return result2;
	}

	/**
	 * 判断时间是否符合正则表达式 Nov 5 09:59
	 */
	public static boolean testRegexUS(String str) {
		String regex = "^[A-Z][a-z]{2}\\s[\\s|123][0-9]\\s[0-5][0-9]\\:[0-5][0-9]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 时间字符串转毫秒
	 * 
	 * @param timeStr
	 * @return
	 * @throws ParseException
	 */
	public static long string2TimeInMillis(String timeStr)
			throws ParseException {
		timeStr = testTime(timeStr);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c1 = Calendar.getInstance();
		c1.setTime(df.parse(timeStr));
		long millis = c1.getTimeInMillis();
		return millis;
	}

	public static long string2TimeInMillisUS(String timeStr)
			throws ParseException {
		DateFormat df = new SimpleDateFormat("MMM dd HH:mm", Locale.US);
		Calendar c1 = Calendar.getInstance();
		c1.setTime(df.parse(timeStr));
		long millis = c1.getTimeInMillis();
		return millis;
	}

	/**
	 * 判断是否符合正则表达式 yyyy-MM-dd HH:mm:ss
	 */
	public static boolean testRegex(String str) {
		String regex = "^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))($|\\s([0-1]\\d|[2][0-3])\\:[0-5]\\d\\:[0-5]\\d)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		boolean b = m.matches();
		return b;
	}

	// 正则表达式匹配时间 格式为 2011-11-03 12:00:00
	public static boolean matchTime(String time) {
		String regex = "^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))($|\\s([0-1]\\d|[2][0-3])\\:[0-5]\\d\\:[0-5]\\d)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(time);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 获得今年年初的毫秒值,因为在文件中的日期格式没有年,所以需要减去本年度之前的毫秒值
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Long getYearMillis() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		String d = "" + year + "-01-01 00:00:00";

		return string2TimeInMillis(d);
	}

	public static void main(String[] args) {
//		System.out.println(getTodayTime());
//		System.out.println(getNow());
//		System.out.println(getForeHour());
		// System.out.println(getStart("Dec 9 14:53"));
		// System.out.println(getEnd("Dec 9 14:53"));
//		System.out.println(testRegex("2011-12-13 8:05:00"));
//		System.out.println(replaceMonthType("Dec 02 01:55"));
		
		
		String temp =1328144173974L+"";
		System.out.println(temp.format("yyyy-MM-dd hh:mm:ss", null));
		
	}
	
	// 根据文件的时间获取结束时间
	public static String replaceMonthType(String s) {
		String month = null;
		String str = s.substring(0, s.indexOf(" ")).trim();

		if (str.equals("Jan")) {
			month = "01";
		} else if (str.equals("Feb")) {
			month = "02";
		} else if (str.equals("Mar")) {
			month = "03";
		} else if (str.equals("Apr")) {
			month = "04";
		} else if (str.equals("May")) {
			month = "05";
		} else if (str.equals("Jun")) {
			month = "06";
		} else if (str.equals("Jul")) {
			month = "07";
		} else if (str.equals("Aug")) {
			month = "08";
		} else if (str.equals("Sept")) {
			month = "09";
		} else if (str.equals("Oct")) {
			month = "10";
		} else if (str.equals("Nov")) {
			month = "11";
		} else if (str.equals("Dec")) {
			month = "12";
		}
		Calendar c = Calendar.getInstance(Locale.CHINA);
		int year = c.get(Calendar.YEAR);
		String date = s.substring(s.indexOf(" "), s.lastIndexOf(" ")).trim();
		
		String temp =year+"-"+month+"-"+s.substring(s.indexOf(" "), s.length()).trim()+":00";		
		try {
			if(string2TimeInMillis(temp)>c.getTime().getTime()){
				year =year-1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (Integer.parseInt(date) < 10 && date.length()==1) {
			date = "0" + date;
		}

		String result = year + "-" + month + "-" + date + " "+s.trim().substring(s.lastIndexOf(" ")).trim() + ":59";
		return result;
	}
	/**
	 * 毫秒转日期
	 * @param str
	 * @return
	 */
	public static String getDateTimeByMillisecond(String str) {
		Date date = new Date(Long.valueOf(str));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = format.format(date);
		return time;
	}
}
