package com.ok;

public class TestDate {
	public static void main(String[] args) {
		
		
		String date = "19000228";
		vilidate(date);
		
//		isLeapYear("2000");
//		isLeapYear("2004");
//		isLeapYear("2011");
	}
		
		

	public static void vilidate(String date) {
		// TODO Auto-generated method stub
		
		boolean boo = false;
		String year = date.substring(0,4);
		String month = date.substring(4,6);
		String day = date.substring(6,8);
		
		int i_month = Integer.parseInt(month);
		int i_day = Integer.parseInt(day);
		
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
		System.out.println(boo);
	}
	
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

}
