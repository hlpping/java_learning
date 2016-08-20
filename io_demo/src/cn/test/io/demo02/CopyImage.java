package cn.test.io.demo02;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class CopyImage {
	
	String input = "input\\a.jpg";
	String output = "output\\b.jpg";
	/*
	 * 字符流读取数据的时候, 读取的是二进制, 返回的是字符. 其中做了自动解码工作.
	 * 字符流写出数据的时候, 接收的实参是字符, 写出到文件中的是二进制. 其中左了自动编码的工作.
	 * 如果使用字符流拷贝图片, 那么字符流也会将图片中的二进制数据转为字符, 而图片中的二进制数据不一定真正对应字符. 在转换时可能出现乱码.
	 * 而写出的时候, 将乱码再转回二进制, 这时就出错了, 不是我们想要拷贝的数据. 
	 */
	@Test
	public void test1() throws IOException{
		FileReader reader = new FileReader(input);
		FileWriter writer = new FileWriter(output);

		char[] buf = new char[1024];
		int len;
		while ((len = reader.read(buf)) != -1)
			writer.write(buf, 0, len);

		reader.close();
		writer.close();
	}
	@Test
	//数组拷贝
	public void test2() throws IOException{
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(input);
			out = new FileOutputStream(output);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) != -1)
				out.write(buf); // 将数组中所有数据写出, 注意不要犯这种错误
		} finally {
			CloseUtil.close(in, out);
		}
	}
	@Test
	//单个拷贝
	public void test3() throws IOException{
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(input);
			out = new FileOutputStream(output);
			int b;
			while ((b = in.read()) != -1)
				out.write(b); // 循环读取一个字节, 判断不是文件末尾(-1), 就使用输出流输出
		} finally {
			CloseUtil.close(in, out);
		}
	}
	@Test
	//缓冲区字节流
	public void test4Buffered() throws IOException{
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(input));
			out = new BufferedOutputStream(new FileOutputStream(output));
			int b;
			while ((b = in.read()) != -1)
				out.write(b);
		} finally {
			CloseUtil.close(in, out);
		}
	}
	
	@Test
	public void test5() throws IOException{
		FileInputStream in = new FileInputStream(input);
		int b;
		while ((b = in.read()) != -1)
			System.out.print((byte) in.read()+" ");
		in.close();
	}
	@Test
	public void test6() throws IOException{
		FileInputStream in = new FileInputStream(input);
		System.out.println((byte) in.read());
		System.out.println((byte) in.read());
		System.out.println((byte) in.read());
		System.out.println((byte) in.read());
		System.out.println((byte) in.read());
		System.out.println((byte) in.read());
		in.close();
	}
}
