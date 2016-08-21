package com.summary.time.pre;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import cn.test.time.demo01.TimeTools;

public class RegexTime {
	
	@Test
	public void test04(){

		System.out.println(vilidate("2009-01-31 24:00:00"));
		System.out.println(vilidate("2009-02-29 12:23:23"));
		System.out.println(vilidate("2009-02-28 12:23:23"));
		System.out.println(vilidate("2009-02-02 12:23:23"));
		System.out.println(vilidate("2009-02-02 24:00:23"));
		System.out.println(vilidate("2009-01-02 12:60:23"));
		
	}
	
	/**
	 * 判断年份的合法性
	 * @param date
	 * @return 
	 */
	public static boolean vilidate(String date) {
		// TODO Auto-generated method stub
		
		boolean boo = false;
		if(!checkDateFormat(date)){
			return false;
		}
		if(date==null || date.trim().equals("")){
			return false;
		}
		date = date.trim();
		String year = date.substring(0,4);
		String month = date.substring(5,7);
		String day = date.substring(8,10);
		String hour = date.substring(11,13);
		String minute = date.substring(14,16);
		String second = date.substring(17,19);
		
		System.out.println(year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second);
		
		int i_month = Integer.parseInt(month);
		int i_day = Integer.parseInt(day);
		int i_hour = Integer.parseInt(hour);
		int i_minute = Integer.parseInt(minute);
		int i_second = Integer.parseInt(second);
		
		if(i_month==1 || i_month==3 || i_month==5|| i_month==7 || i_month==8 || i_month==10|| i_month==12){
			if(i_day>=1 && i_day <=31 ){
				boo = true;
			}else{
				boo = false;
			}
		} else if(i_month==4 || i_month==6 || i_month==9|| i_month==11 ){
			if(i_day>=1 && i_day <=30 ){
				boo = true;
			}else{
				boo = false;
			}
		} else if(i_month==2 ){
			if( isLeapYear(year) ){
				if(i_day>=1 && i_day <=29 ){
					boo = true;
				}else{
					boo = false;
				}
			}else{
				if(i_day>=1 && i_day <=28 ){
					boo = true;
				}else{
					boo = false;
				}
			}
		}
		
		if(i_hour<0){
			boo= false;
		}
		if(i_hour>23){
			boo= false;
		}
		if(i_minute<0){
			boo= false;
		}
		if(i_minute>59){
			boo= false;
		}
		if(i_second<0){
			boo= false;
		}
		if(i_second>59){
			boo= false;
		}
		return boo;
	}
	/**
	 * 判断是否是闰年
	 * @param yearStr
	 * @return
	 */
	public static boolean isLeapYear(String yearStr){
		
		int year = Integer.parseInt(yearStr);
		boolean boo = false;
		if( year%400==0 ){
			boo = true;
		}else if(year%4==0 && year%100!=0){
			boo = true;
		}
		return boo;
	}
	
	public static boolean checkDateFormat(String date) {
		String eL="^(\\d){4}(\\-{1})(\\d){2}(\\-{1})((\\d){2})(\\s){1}(\\d){2}(\\:{1})((\\d){2})(\\:{1})((\\d){2})$";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(date);
		return m.matches();
	}
}
