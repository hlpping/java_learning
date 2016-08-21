package com.summary.time.pre;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TimeDemo01 {
	
	/**
	 * ��Ӣ�ĵ�ʱ���ʽת���� 19���ַ��ʱ���ʽ
	 */
	@Test
	public void test01() {
		Calendar c = Calendar.getInstance(Locale.CHINA);

		// ���ַ���ʽ-->yyyy-MM-dd HH:mm:ss
		String s = "Dec 9 14:53";

		// ��(��)�� ʱ����
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
		String hour = s.substring(s.lastIndexOf(" "), s.lastIndexOf(" ") + 3).trim();
		String minite = s.substring(s.lastIndexOf(" ") + 4, s.lastIndexOf(" ") + 6).trim();

		String result1 = year + "-" + month + "-" + date + " " + hour + ":00:00";
		System.out.println(result1);
		String result2 = year + "-" + month + "-" + date + " " + hour + ":" + minite + ":59";
		System.out.println(result2);

	}
	
	/**
	 * ��calendar�����л��ʱ��
	 */
	@Test
	public void test02() {
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH)+1);
		System.out.println(c.get(Calendar.DATE));
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.SECOND));
	}

	@Test
	public void test03() {
		long today = 132600000;
		//1326124619000
		//1326038422000
		String tomorrow = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS ")
				.format(new Date(today));
		System.out.println(tomorrow);
		
//		System.out.println((new Date()).getTime());
	}

	@Test
	public void test04() {
		String str = "1326124619000";
		Date date = new Date(Long.valueOf(str));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = format.format(date);
		System.out.println(time);
	}
	
	@Test 
	public void Testregexp(){
	        //Pattern p = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\/\\/\\s]?((((0?"+"[13578])|(1[02]))[\\/\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))" +"|(((0?[469])|(11))[\\/\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|" +"(0?2[\\/\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12"+"35679])|([13579][01345789]))[\\/\\/\\s]?((((0?[13578])|(1[02]))" +"[\\/\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))" +"[\\/\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\/\\/\\s]?((0?[" +"1-9])|(1[0-9])|(2[0-8]))))))");
	        Pattern p = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\-\\s]?((((0?" +"[13578])|(1[02]))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))" +"|(((0?[469])|(11))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|" +"(0?2[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12" +"35679])|([13579][01345789]))[\\-\\-\\s]?((((0?[13578])|(1[02]))" +"[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))" +"[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\-\\s]?((0?[" +"1-9])|(1[0-9])|(2[0-8]))))))");
	       
	        String s = "2003-02-20";
	          System.out.println(s + " " + p.matcher(s).matches());
	 
	          s = "2000-02-29";
	          System.out.println(s + " " + p.matcher(s).matches());
	 
	          s = "2004-04-31";
	          System.out.println(s + " " + p.matcher(s).matches());
	 
	          s = "2004-04-30";
	          System.out.println(s + " " + p.matcher(s).matches());
	 
	          s = "2004/04/30";
	          System.out.println(s + " " + p.matcher(s).matches());
	 
	          s = "2004-09-30";
	          System.out.println(s + " " + p.matcher(s).matches());
	 
	    }
	
	public static boolean regexDate(String str){
		 Pattern p = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\-\\s]?((((0?" +"[13578])|(1[02]))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))" +"|(((0?[469])|(11))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|" +"(0?2[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12" +"35679])|([13579][01345789]))[\\-\\-\\s]?((((0?[13578])|(1[02]))" +"[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))" +"[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\-\\s]?((0?[" +"1-9])|(1[0-9])|(2[0-8]))))))");
	     return p.matcher(str).matches();
	}
	
	@Test
	public void test1(){
		System.out.println(regexDate("2004-2-29"));
		System.out.println(regexDate("2004/2/28"));
		System.out.println(regexDate("2004-9-30"));
		System.out.println(regexDate("2004-12-29"));
		System.out.println(regexDate("2004-12-31"));
		
		System.out.println("-------------------");
		System.out.println(regexDate("2013-04-08"));
	}
	
	/**
	 * �ж��Ƿ���������ʽ  yyyy-MM-dd HH:mm:ss
	 */
	public static boolean testRegex(String str) {
		String regex = "^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))($|\\s([0-1]\\d|[2][0-3])\\:[0-5]\\d\\:[0-5]\\d)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		boolean b = m.matches();
		return b;
	}
	/**
	 * ��ʱ��ת���ɺ���ֵ,�������Ƚ�ʱ��Ĵ�С
	 * @param timeStr	ʱ���ַ�yyyy-MM-dd HH:mm:ss
	 * @return			����ֵ	Long
	 * @throws ParseException
	 */
	public static long string2TimeInMillis(String timeStr) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c1 = Calendar.getInstance();		
		c1.setTime(df.parse(timeStr));		
		long millis = c1.getTimeInMillis();
		return millis;
	}	

	@Test
	public void test05() {
		String s1 = "2008-01-25 09:12:09";
		String s2 = "2008-01-24 09:12:09";

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		try {
			c1.setTime(df.parse(s1));
			c2.setTime(df.parse(s2));

		} catch (ParseException e) {
			System.out.println("��ʽ����ȷ");
			e.printStackTrace();
		}
		int result = c1.compareTo(c2);
		if (result == 0)
			System.out.println("c1==c2");
		else if (result < 0)
			System.out.println("c1<c2");
		else
			System.out.println("c1>c2");
	}
	
	@Test
	public void test06(){
		
		String str = "aaaabbbbbcccbbbbbd";  
        String[] strs = str.split("(?<=(\\w))(?!\\1)");  
        Arrays.sort(strs, new Comparator<String>() {  
            public int compare(String a, String b) {  
                return b.length() - a.length();  
            }  
        });  
        for (String s : strs) 
        	System.out.println(s);  
		
	}
	
	private static Long getYearMillis() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);
		String d = "" + year + "-01-01 00:00:00";

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Calendar c1 = Calendar.getInstance();
		try {
			c1.setTime(df.parse(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Long iMillis = c1.getTimeInMillis();
		return iMillis;
	}
}
