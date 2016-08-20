package cn.test.io.demo02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class Demo02_Stream extends SuperTest{
	
//	String input ="input\\src.txt";
//	String output ="output\\src.txt";
	
	@Test
	public void testFileInputStream() throws IOException {
		FileInputStream in = new FileInputStream(input);
		int b;
		while ((b = in.read()) != -1) {
			if ((byte) b < 0) {
				byte b1 = (byte) b;
				byte b2 = (byte) in.read();
				byte[] arr = new byte[] { b1, b2 };
				System.out.print(new String(arr));
			} else
				System.out.print((char) b);
		}
		in.close();
	}

	@Test
	public void testFileReader() throws IOException {
		FileReader reader = new FileReader(input);
		int ch;
		while ((ch = reader.read()) != -1)
			System.out.print((char) ch);
		reader.close();
	}

	@Test
	public void testFileOutputStream() throws IOException {
		FileOutputStream out = new FileOutputStream(output);
		out.write("sdfh受到官方机构大举".getBytes());
		out.close();
	}

	@Test
	public void testFileWriter() throws IOException {
		FileWriter writer = new FileWriter(output);
		writer.write("玛利亚");
		writer.close();
	}
	
	//拷贝文字 :字节
	@Test
	public void testCopyByInputStream() throws IOException{
		FileInputStream in =null;
		FileOutputStream out =null;
		try{
			in=new FileInputStream(input);
			out =new FileOutputStream(output);
			byte[] buf=new byte[1024];
			int len;
			while((len=in.read(buf))!=-1)
				out.write(buf,0,len);
		}finally{
			CloseUtil.close(in, out);
		}
	}
	//拷贝文件 :字符
	@Test
	public void testCopy() throws IOException{
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("input\\a.jpg");
			out = new FileOutputStream("output\\a.jpg");
			int b;
			while ((b = in.read()) != -1)
				out.write(b); // 循环读取一个字节, 判断不是文件末尾(-1), 就使用输出流输出
		} finally {
			CloseUtil.close(in, out);
		}
	}
}
