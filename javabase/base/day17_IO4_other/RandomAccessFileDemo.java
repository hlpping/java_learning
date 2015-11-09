package base.day17_IO4_other;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("test.txt", "rw"); // 定义随机读写文件, 模式为读取写入
		raf.seek(5); // 指向1号索引位置
		//		System.out.println(raf.readChar()); // 读取2个字节, 转为char
		//		raf.writeBytes("xxxxx"); // 将3号索引处覆盖
		System.out.println(raf.readLine());
		raf.write('\r');
		raf.write('\n');
		raf.writeBytes("bye");
		raf.close();
	}
}
