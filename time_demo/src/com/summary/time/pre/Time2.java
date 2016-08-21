package com.summary.time.pre;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Time2 {
	public static void main(String[] args) {
		String time1 ="2011-11-11";
		String time2 ="2011-11-11 11";
		String time3 ="2011-11-11 11:11";
		String time4 ="2011-11-11 11:11:11";
		
		System.out.println(testTime(time1));
		System.out.println(testTime(time2));
		System.out.println(testTime(time3));
		System.out.println(testTime(time4));
		System.out.println(testTime(""));
		
		System.out.println(getTodayTime());
	}

	private static String testTime(String time) {
		if(time.trim().length()==0){
			time=getTodayTime();
		}
		
		if(time.trim().length()==10){
			time=time+" 09:00:00";
		}
		if(time.trim().length()==13){
			time=time+":00:00";
		}
		if(time.trim().length()==16){
			time=time+":00";
		}
		
		return time;
	}
	@SuppressWarnings("static-access")
	public static String getTodayTime(){
		Calendar c=Calendar.getInstance(Locale.CHINA);
		
		@SuppressWarnings("unused")
		Date today=c.getTime();
		c.getTimeInMillis();
		int year =c.YEAR;
		int month =c.MONTH;
		int date= c.DATE;
		String strDate=null;
		if(date<10){
			strDate="0"+date;
		}
		String dayTime =""+year+"-"+month+"-"+strDate+" "+"09:00:00";
		
		return dayTime;				
	}
}
