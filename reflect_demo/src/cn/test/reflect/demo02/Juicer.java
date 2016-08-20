package cn.test.reflect.demo02;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Juicer {
	@SuppressWarnings("unchecked")
	public void run(Fruit fruit) throws Exception{
		InputStream in =Juicer.class.getClassLoader()
			.getResourceAsStream("cn/test/reflect/demo02/config.properties");
		Properties prop =new Properties();
		prop.load(in);
		
		String methodNames=prop.getProperty("method");
		String[] names =methodNames.split(",");
		for(String name : names){
			Class clazz =fruit.getClass();
			Method m =clazz.getMethod(name);
			m.invoke(fruit);
		}
		
	}}
