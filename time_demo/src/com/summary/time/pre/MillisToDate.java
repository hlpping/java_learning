package com.summary.time.pre;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MillisToDate {

	public static String getDateTimeByMillisecond(String str) {
		Date date = new Date(Long.valueOf(str));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = format.format(date);
		return time;
	}
	
	public static Date convertToDate(String input, String formatType) {
		Date inputDate = new Date();
		try {
			if (null != formatType && formatType.equalsIgnoreCase("yyyyMMdd")) {
				GregorianCalendar goc = new GregorianCalendar(Integer.parseInt(input.substring(0, 4)), Integer.parseInt(input.substring(4, 6)) - 1, Integer.parseInt(input.substring(6, 8)));
				inputDate = goc.getTime();
			} else if (null != formatType && formatType.equalsIgnoreCase("yyyy-MM-dd")) {
				GregorianCalendar goc = new GregorianCalendar(Integer.parseInt(input.substring(0, 4)), Integer.parseInt(input.substring(5, 7)) - 1, Integer.parseInt(input.substring(8, 10)));
				inputDate = goc.getTime();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputDate;
	}

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		String str = String.valueOf(calendar.getTimeInMillis());
		String time1 = getDateTimeByMillisecond(str);
		String time2 = getDateTimeByMillisecond("1326360745524");
		System.out.println(time1 + "\n" + time2);
	}
}
