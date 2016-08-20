package cn.test.io.demo04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class PipedStreamDemo {
	@Test
	public void test1() throws IOException{
		// 使用管道流输入输出数据
		PipedInputStream in = new PipedInputStream(); // 管道输入流, 可以连接一个管道输出流, 从中读取数据
		PipedOutputStream out = new PipedOutputStream(); // 管道输出流, 可以接连介意管道输入流, 向输入流中输出数据

		in.connect(out); // 连接输入输出流, 写成 out.connect(in); 也可以

		out.write("hello".getBytes()); // 输出流写出数据

		int b;
		while ((b = in.read()) != -1)
			System.out.print((char) b); // 输入流读取数据, 显示到控制台

		in.close();
		out.close();
	}
	@Test
	public void test2() throws IOException{
		// 对管道流进行包装, 将字节输出流包装成PrintStream, 可以输出一行字符, 将输入流包装成BufferedReader, 可以读取一行字符.
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);

		PrintStream ps = new PrintStream(out, true, "UTF-8"); // 对输出流进行包装, 提供将GBK字符解码的功能, 自动刷出, 打印一次之后自动换行

		InputStreamReader isr = new InputStreamReader(in, "UTF-8"); // 包装, 提供字节解码功能
		BufferedReader reader = new BufferedReader(isr); // 包装, 提供读取一行的功能

		ps.println("hello 中文网"); // 将"hello\r\n"编码成GBK字节, 写出, 刷出.
		System.out.println(reader.readLine());

		ps.println("bye 中文网");
		System.out.println(reader.readLine());
	}
}
