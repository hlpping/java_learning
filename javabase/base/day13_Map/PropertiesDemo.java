package base.day13_Map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class PropertiesDemo {
	@Test
	public void test1() throws IOException{
		Properties prop =new Properties();
		prop.load(new FileInputStream("src/day13_Map/dbcpconfig.properties"));
		
		System.out.println(prop.get("driverClassName"));
		System.out.println(prop.get("url"));
		System.out.println(prop.get("username"));
		System.out.println(prop.get("password"));
	}
	@Test
	public void test2(){
		Properties prop = new Properties(); // 通常只用来存储字符串类型, 所以不指定泛型了
		prop.setProperty("name", "Don");
		prop.setProperty("age", "26");
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
	}
}
