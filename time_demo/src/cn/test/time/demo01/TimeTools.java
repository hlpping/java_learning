package cn.test.time.demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeTools {

	public static final SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat formatHour = new SimpleDateFormat("yyyy-MM-dd HH");
	public static final SimpleDateFormat formatMinute = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat formatSecond = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 日期转换成字符串
	 * 
	 * @param date
	 * @return string
	 */
	public static String dateToStr(Date date, SimpleDateFormat format) {
		if (format == null) 
			format = formatSecond;
		return format.format(date);
	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param string
	 * @return date
	 * @throws ParseException 
	 */
	public static Date StrToDate(String str, SimpleDateFormat format) throws ParseException {
		if (format == null) 
			format = formatSecond;
		return format.parse(str);
	}
	
	/**
	 * 根据时间字符串获得时间毫秒值
	 * @param date		String:时间字符串
	 * @param format 	String:输入的时间的类型
	 * @return
	 * @throws ParseException
	 */
	public static long strToMillis(String date , SimpleDateFormat format) throws ParseException{
		return StrToDate(date, format).getTime();
	}
	
	/**
	 * 时间的毫秒转化为时间字符串
	 * @param millis 	Long:毫秒
	 * @param format	String:输出的时间的类型
	 * @return
	 */
	public static String millisToStr(long millis , SimpleDateFormat format){
		return dateToStr(new Date(millis), format);
	}
	
	/**
	 * 毫秒转日期
	 * @param millis
	 * @return
	 */
	public static Date millisToDate(long millis){
		return new Date(millis);
	}
	
	/**
	 * 日期转毫秒
	 * @param date
	 * @return
	 */
	public static long dateToMillis(Date date){
		return date.getMinutes();
	}
	
	/**
	 * 验证日期格式的正确性
	 * @param date
	 * @return
	 */
	public static boolean checkDate(String date) {
//		String eL = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1][0-9])|([2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
//		String eL = "^((\\d{2}(([02468][048])|([13579][26]))(\\-){1}((((0?[13578])|(1[02]))(\\-){1}((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))(\\-){1}((0?[1-9])|([1-2][0-9])|(30)))|(0?2(\\-){1}((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))(\\-){1}((((0?[13578])|(1[02]))(\\-){1}((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))(\\-){1}((0?[1-9])|([1-2][0-9])|(30)))|(0?2(\\-){1}((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1][0-9])|([2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9]))))){1}$";
		
		String eL = "^((\\d{2}(([02468][048])|([13579][26]))(\\-){1}((((0?[13578])|(1[02]))(\\-){1}((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))(\\-){1}((0?[1-9])|([1-2][0-9])|(30)))|(0?2(\\-){1}((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))(\\-){1}((((0?[13578])|(1[02]))(\\-){1}((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))(\\-){1}((0?[1-9])|([1-2][0-9])|(30)))|(0?2(\\-){1}((0?[1-9])|(1[0-9])|(2[0-8]))))))$";
		
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(date);
		return m.matches();
	}
	
	/**
	 * 判断年份的合法性
	 * @param date
	 * @return 
	 */
	public static boolean vilidate(String date) {
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
	


}
