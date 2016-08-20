package cn.test.spring.config;

import java.util.Date;

import org.junit.Test;

public class App {
	
	@Test
	public void test01(){
		System.out.println("path =  " + Config.getConfigPath());
	}
	
	@Test
	public void test02(){
//		Config.getCtx().getBean("");
	}
	
}
