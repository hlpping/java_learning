package cn.test.demo01.string;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class TestString {
	
	@Test
	public void test01(){
		System.out.println(StringUtils.isBlank(null));
		System.out.println(StringUtils.isBlank(""));
		System.out.println(StringUtils.isBlank("   "));
		
		System.out.println(StringUtils.isBlank("\t \n \f \r"));
		
		System.out.println("-----------");
		
		System.out.println(StringUtils.isNotBlank(null));
		System.out.println(StringUtils.isNotBlank(""));
		System.out.println(StringUtils.isNotBlank("   "));
		System.out.println(StringUtils.isNotBlank("\t \n \f \r"));
	}
	
	@Test
	public void test02(){
		System.out.println(StringUtils.isEmpty(null));
		System.out.println(StringUtils.isEmpty(""));
		System.out.println(StringUtils.isEmpty("   "));
		System.out.println(StringUtils.isEmpty("bob"));
		System.out.println(StringUtils.isEmpty(" bob  "));
		
		System.out.println("-----------");
		
		System.out.println(StringUtils.isNotEmpty(null));
		System.out.println(StringUtils.isNotEmpty(""));
		System.out.println(StringUtils.isNotEmpty("   "));
	}
	
	@Test
	public void test03(){

		System.out.println(StringUtils.trim(null));
		System.out.println(StringUtils.trim(""));
		System.out.println(StringUtils.trim(" "));
		System.out.println(StringUtils.trim(" \b \t \n \f \r "));
		System.out.println(StringUtils.trim(" d d dd "));
		System.out.println(StringUtils.trim("dd "));
		System.out.println(StringUtils.trim(" dd "));
		
		System.out.println("-----------");
		
		System.out.println(StringUtils.trimToNull(null));
		System.out.println(StringUtils.trimToNull(""));
		System.out.println(StringUtils.trimToNull(" "));
		System.out.println(StringUtils.trimToNull(" \b \t \n \f \r "));
		System.out.println(StringUtils.trimToNull(" d d dd "));
		System.out.println(StringUtils.trimToNull("dd "));
		System.out.println(StringUtils.trimToNull(" dd "));
		
		System.out.println("-----------");
		
		System.out.println(StringUtils.trimToEmpty(null));
		System.out.println(StringUtils.trimToEmpty(""));
		System.out.println(StringUtils.trimToEmpty(" "));
		System.out.println(StringUtils.trimToEmpty(" \b \t \n \f \r "));
		System.out.println(StringUtils.trimToEmpty(" d d dd "));
		System.out.println(StringUtils.trimToEmpty("dd "));
		System.out.println(StringUtils.trimToEmpty(" dd "));
		
	}
	
	@Test
	public void test04(){
		
		
		
		
		
	}
}
