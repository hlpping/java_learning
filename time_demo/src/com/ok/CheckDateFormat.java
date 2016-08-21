package com.ok;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试时间格式是否正确,利用正则表达式
 * @author shuang
 *
 */
public class CheckDateFormat {
	public static boolean checkDate(String date) {
		String eL = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1][0-9])|([2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(date);
		boolean b = m.matches();
		if (b) {
			System.out.println("格式正确");
		} else {
			System.out.println("格式错误");
		}
		return b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkDate("2009-01-01 12:13:12");
		checkDate("2009-1-1 12:13:12");
		checkDate("2009/01/01 12:13:12");
		checkDate("2009/1/1 12:13:12");
		checkDate("2009-01-01");
		checkDate("2009/01/01");
		checkDate("2009/13/01");
		checkDate("2009/01/01 24:59:59");
		checkDate("20090131");

	}

}
