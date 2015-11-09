package base.day17_IO4_other;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class ByteArrayStreamDemo {
	@Test
	public void test1() throws IOException{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		out.write(97); // 每次写出, 都是写到内存
		out.write(98);
		out.write(99);
		byte[] arr = out.toByteArray(); // 从内存中取出之前写入的所有字节
		System.out.println(Arrays.toString(arr));
		out.close();
	}
	@Test
	public void test2() throws IOException{
		FileInputStream in = new FileInputStream("test.txt");
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		int b;
		while ((b = in.read()) != -1)
			out.write(b); // 从文件中读取, 先保存到内存中
		in.close();

		byte[] arr = out.toByteArray(); // 从内存中获取所有写入的数据
		FileOutputStream fos = new FileOutputStream("test1.txt");
		fos.write(arr); // 将整个数组一次性写出到文件
		fos.close();
	}
	@Test
	public void test3() throws IOException{
		byte[] arr = new byte[] { 97, 98, 99 };
		ByteArrayInputStream in = new ByteArrayInputStream(arr);

		int b;
		while ((b = in.read()) != -1)
			System.out.println(b); // 从字节数组中读取数据

		in.close();
	}
	
}
