package base.day17_IO4_other;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class DataStreamDemo {
	@Test
	public void test1() throws IOException{
		FileOutputStream out = new FileOutputStream("test.txt");
		out.write(97); // 写出1个字节, 将实参int值转为byte写出.a
		out.close();
	}
	@Test
	public void test2() throws IOException{
		DataOutputStream out = new DataOutputStream(new FileOutputStream("test.txt"));
		out.writeInt(97); // 写出一个int, 4个字节, 00000000 00000000 00000000 01100001
		out.writeChar(97); // 写出一个char, 2个字节, 00000000 01100001
		out.close();
	}
	@Test
	public void test3() throws IOException{
		DataInputStream in = new DataInputStream(new FileInputStream("test.txt"));
		char c = in.readChar(); // 从流中读2个字节, 转为char返回
		int i = in.readInt(); // 从流中读4个字节, 转为int返回
		System.out.println(i);
		System.out.println(c);
		in.close();
	}
	
}
