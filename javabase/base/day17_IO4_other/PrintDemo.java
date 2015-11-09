package base.day17_IO4_other;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class PrintDemo {
	@Test
	public void test1() throws IOException{
		FileOutputStream out = new FileOutputStream("test.txt");
		//		out.write(97); // 写出一个字节, 传入的实参是int, 内部会将int强转为byte, 输出到文件
		out.write(24929); // 将24929强转为byte输出, 转换的结果是97, 所以文件中打开看到的还是a
		out.close();
	}
	@Test
	public void test2() throws IOException{
		FileWriter writer = new FileWriter("test.txt");
		//		writer.write(97); // 写出一个字符, 传入实参是int, 内部会将int强转为char, 输出到文件
		writer.write(24929); // 将24929强转为char输出, 结果是慡
		writer.close();
	}
	@Test
	public void test3() throws FileNotFoundException{
		PrintStream ps = new PrintStream("test.txt");
//		ps.write(97);	//a
//		ps.write(24929);	//a
//		ps.print(97); // 自动装箱成Integer, 调用其toString()方法	//97
		ps.println(97); // 在print基础上加上\r\n	//97
		ps.close();
	}
	@Test
	public void test4() throws IOException{
		PrintWriter pw = new PrintWriter("test.txt");
//		pw.write(97);	//a
//		pw.write(24929);	//慡
		pw.print(97);	// 自动装箱成Integer, 输出其toString()方法的返回值 97
//		pw.println(97); // 加上了\r\n
		pw.close();
	}
	@Test
	public void test5() throws UnsupportedEncodingException, FileNotFoundException{
		PrintStream ps = new PrintStream(new FileOutputStream("test.txt"), true, "UTF-8");
		ps.print("下课了, 吃饭去吧, 大家下午见!");
	}
}
