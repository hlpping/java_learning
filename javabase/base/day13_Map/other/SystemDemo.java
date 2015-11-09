package base.day13_Map.other;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.junit.Test;

public class SystemDemo {
	
	@Test
	public void test1(){
		// finally中的代码是一定会执行的吗? 一般情况下是的, 除非System.exit();
		try {
			System.out.println("try");
			System.exit(0);
			if (1 == 1)
				throw new RuntimeException();
			System.out.println("after exception");
		} finally {
			System.out.println("finally");
		}		
	}
	@Test
	public void test2() throws IOException{
		System.out.println("hi"); 
		// 使用System类中的属性out, 标准输出流, out是一个PrintStream打印流, 这个默认流指向控制台, 也就是向控制台输出.
		int b = System.in.read(); 
		// 使用System类中的属性in, 标准输入流, in是一个InputStream输入流, 这个流默认指向键盘输入, 也就是从键盘读取数据.
		System.out.println(b);
		
		// Runtime.getRuntime().exec("E:\\Tencent\\QQ\\Bin\\QQ.exe");	// 运行本地程序
	}
	@Test
	public void test3(){
		Properties prop = System.getProperties(); // 获取当前系统的所有参数配置
		Enumeration<String> e = (Enumeration<String>) prop.propertyNames(); // 获取prop中所有name的枚举
		while (e.hasMoreElements()) { // 遍历这个枚举以获得每一个name
			String name = e.nextElement();
			System.out.println(name + "=" + prop.getProperty(name)); // 打印每一个name, 以及name对应的value
		}
	}
}
