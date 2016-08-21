package cn.test.time.demo01;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import com.summary.time.pre.TimeFormat;

public class TimeToolsTest {
	
	@Test
	public void test01() throws ParseException {
//		System.out.println("字符串转日期：" + ConvertDemo.StrToDate(ConvertDemo.DateToStr(date)));
		
		System.out.println(TimeTools.StrToDate("2012-01-01", TimeTools.formatDate));
		System.out.println(TimeTools.StrToDate("2012-01-01 12:01:01", TimeTools.formatSecond));
	}
	
	@Test
	public void test02(){
		Date date = new Date();
		System.out.println("日期转字符串：" + TimeTools.dateToStr(date,TimeTools.formatDate));
		
	}
	
	@Test
	public void test03() throws ParseException{
		System.out.println(TimeTools.strToMillis("2012-04-20 01:00:01",null));
		
		System.out.println(TimeTools.millisToStr(System.currentTimeMillis(),null));
	}
	
	@Test
	public void test04(){
		System.out.println(TimeTools.checkDate("2012-04-20"));
		System.out.println(TimeTools.checkDate("2012-04-30"));
		System.out.println(TimeTools.checkDate("2012-04-31"));
		System.out.println(TimeTools.checkDate("2011-02-28"));
		System.out.println(TimeTools.checkDate("2011-02-29"));
		System.out.println(TimeTools.checkDate("2009-01-01"));
		System.out.println(TimeTools.checkDate("2009/01/01"));
		System.out.println(TimeTools.checkDate("2009/13/01"));
		System.out.println(TimeTools.checkDate("20090131"));
		System.out.println(TimeTools.checkDate("2009-1-1 12:13:12"));
		System.out.println(TimeTools.checkDate("2009/01/01 12:13:12"));
		System.out.println(TimeTools.checkDate("2009/1/1 12:13:12"));
		System.out.println(TimeTools.checkDate("2009/01/01 24:59:59"));
		System.out.println(TimeTools.checkDate("2009-01-01 12:13:12"));
		System.out.println(TimeTools.checkDate("2009-02-28 12:13:12"));
		System.out.println(TimeTools.checkDate("2009-02-29 12:13:12"));
		System.out.println(TimeTools.checkDate("2009-01-01 12:13:12"));
		System.out.println("------------------------------------------");
//		System.out.println(TimeTools.checkDate("2009-01-01 24:13:12"));
//		System.out.println(TimeTools.checkDate("2009-01-01 24:00:00"));
//		System.out.println(TimeTools.checkDate("2009-01-01 12:60:12"));
//		System.out.println(TimeTools.checkDate("2009-01-01 12:13:60"));
	}
	
	@Test
	public void test05(){
		System.out.println(TimeTools.vilidate("19000228"));
		System.out.println(TimeTools.isLeapYear("2000"));
		System.out.println(TimeTools.isLeapYear("2004"));
		System.out.println(TimeTools.isLeapYear("2011"));
		
	}
	
	@Test
	public void test06(){
		long time = System.currentTimeMillis();
		System.out.println(time);
		System.out.println(TimeFormat.getDate(time));
		
		int hour = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai")).get(Calendar.HOUR_OF_DAY);
//		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		System.out.println(hour);
	}
	
	@Test
	public void test07(){
		System.out.println(new Date());
		System.out.println(TimeTools.formatDate.format(new Date()));
		long today = System.currentTimeMillis();
		System.out.println(TimeTools.formatDate.format(new Date(today)));
		long fore7 = System.currentTimeMillis()- 7*24*60*60*1000;
		System.out.println(TimeTools.formatDate.format(new Date(fore7)));
	}
	
	@Test
	public void test08(){
		Calendar ca = Calendar.getInstance();
		ca.setTimeInMillis(System.currentTimeMillis()- 7*24*60*60*1000);
		ca.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		System.out.println(TimeTools.formatDate.format(new Date(ca.getTimeInMillis())));
		
		ca.setTimeInMillis(System.currentTimeMillis());
		ca.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		System.out.println(TimeTools.formatDate.format(new Date(ca.getTimeInMillis())));
	}
	
	@Test
	public void test09(){
//		�Ƴ�һ��ʾ��
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.DAY_OF_MONTH,curr.get(Calendar.DAY_OF_MONTH)+7);
		Date date=curr.getTime();

//		�Ƴ�һ����ʾ��
		Calendar curr1 = Calendar.getInstance();
		curr.set(Calendar.MONTH,curr1.get(Calendar.MONTH)+2);
		Date date1=curr1.getTime();

//		�Ƴ�һ��ʾ��
		Calendar curr2 = Calendar.getInstance();
		curr.set(Calendar.YEAR,curr2.get(Calendar.YEAR)+2);
		Date date2=curr2.getTime();
		
		System.out.println(TimeTools.dateToStr(date,null));
		System.out.println(TimeTools.dateToStr(date1,null));
		System.out.println(TimeTools.dateToStr(date2,null));
	}
}
