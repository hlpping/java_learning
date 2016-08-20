package cn.test.io.demo04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

import org.junit.Test;

public class CutFileDemo {
	@Test
	public void merge() throws IOException{
		FileInputStream in1 = new FileInputStream("temp/1.jpg");
		FileInputStream in2 = new FileInputStream("temp/2.jpg");
		FileInputStream in3 = new FileInputStream("temp/3.jpg");
		FileInputStream in4 = new FileInputStream("temp/4.jpg");
		FileInputStream in5 = new FileInputStream("temp/5.jpg");
		FileInputStream in6 = new FileInputStream("temp/6.jpg");

		Vector<InputStream> vector = new Vector<InputStream>();
		vector.add(in1);
		vector.add(in2);
		vector.add(in3);
		vector.add(in4);
		vector.add(in5);
		vector.add(in6);

		Enumeration<InputStream> e = vector.elements();
		SequenceInputStream sis = new SequenceInputStream(e);

		FileOutputStream out = new FileOutputStream("temp/merge.jpg");

		int b;
		while ((b = sis.read()) != -1)
			out.write(b);

		sis.close();
		out.close();
	}
	@Test
	public void cut() throws IOException{
		File file=new File("merge.jpg");
		long srcLen=file.length();	
		long subLen =(srcLen+5)/6; // 计算每一个文件的大小
		int fileNum=1;
		
		BufferedInputStream in =new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(fileNum+".jpg"));
		
		int len = 0;// 用来统计拷贝了多少个字节
		int b;
		while((b =in.read())!=-1){
			out.write(b);
			// 如果len==subLen, 拷贝文件字节等于一个小文件大小, 那么让输入流指向另一个文件.
			if(++len==subLen){
				// 关闭之前的流, 完成上一个文件
				out.close();
				// 让流指向下一个小文件
				out=new BufferedOutputStream(new FileOutputStream(++fileNum +".jpg"));
				len=0;
			}
			
			
		}
	}
}
