package base.day15_IO2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class InputOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		long start =System.currentTimeMillis();
		test1();
//		test2();
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	//拷贝文字 :字节
	private static void test1() throws IOException{
		FileInputStream in =null;
		FileOutputStream out =null;
		try{
			in=new FileInputStream("source.txt");
			out =new FileOutputStream("test.txt");
			byte[] buf=new byte[1024];
			int len;
			while((len=in.read(buf))!=-1)
				out.write(buf,0,len);
		}finally{
			CloseUtil.close(in, out);
		}
	}
	//拷贝文件 :字符
	private static void test2() throws IOException{
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("a.jpg");
			out = new FileOutputStream("b.jpg");
			int b;
			while ((b = in.read()) != -1)
				out.write(b); // 循环读取一个字节, 判断不是文件末尾(-1), 就使用输出流输出
		} finally {
			CloseUtil.close(in, out);
		}
	}
}
