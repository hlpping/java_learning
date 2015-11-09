package base.day30_reflect;

import java.io.InputStream;
import java.util.Properties;

public class JuicerTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		Juicer juicer =new Juicer();
		
		// 获取ClassLoader, 获取输入流, 这个路径从bin目录开始
		InputStream in = JuicerTest.class.getClassLoader()
			.getResourceAsStream("day30_reflect/config.properties"); 
		Properties prop = new Properties();
		prop.load(in); // 加载输入流中的数据

		// 获取配置文件中指定的class
		Class clazz = Class.forName(prop.getProperty("class")); 
		// 使用指定的class创建对象
		Fruit fruit = (Fruit) clazz.newInstance(); 
		juicer.run(fruit);
	}
}
