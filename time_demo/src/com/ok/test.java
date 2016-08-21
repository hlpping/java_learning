package com.ok;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class test {
	
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Test
	public void dd(){
//		�Ƴ�һ��ʾ��
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.DAY_OF_MONTH,curr.get(Calendar.DAY_OF_MONTH)+7);
		Date date=curr.getTime();

//		�Ƴ�һ����ʾ��
		Calendar curr1 = Calendar.getInstance();
		curr.set(Calendar.MONTH,curr1.get(Calendar.MONTH)+1);
		Date date1=curr1.getTime();

//		�Ƴ�һ��ʾ��
		Calendar curr2 = Calendar.getInstance();
		curr.set(Calendar.YEAR,curr2.get(Calendar.YEAR)+1);
		Date date2=curr2.getTime();
		
		System.out.println(date);
		System.out.println(date1);
		System.out.println(date2);
	}
	//����һ,������
	private static void test02() {
		Calendar ca = Calendar.getInstance();
		ca.setTimeInMillis(System.currentTimeMillis()- 7*24*60*60*1000);
		ca.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		System.out.println(dateFormat.format(new Date(ca.getTimeInMillis())));
		
		ca.setTimeInMillis(System.currentTimeMillis());
		ca.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		System.out.println(dateFormat.format(new Date(ca.getTimeInMillis())));
	}

	//������ת�ַ�
	private static void test01() {
		System.out.println(new Date());
		System.out.println(dateFormat.format(new Date()));
		
		long today = System.currentTimeMillis();
		long fore7 = System.currentTimeMillis()- 7*24*60*60*1000;
		System.out.println(dateFormat.format(new Date(today)));
		System.out.println(dateFormat.format(new Date(fore7)));
	}
}
