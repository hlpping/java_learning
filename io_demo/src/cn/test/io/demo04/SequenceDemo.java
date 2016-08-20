package cn.test.io.demo04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import org.junit.Test;

public class SequenceDemo {
	@Test
	public void test1() throws IOException{
		// 合并两个文件
		FileInputStream in1=new FileInputStream("temp/1.txt");
		FileInputStream in2=new FileInputStream("temp/2.txt");
		
		SequenceInputStream in =new SequenceInputStream(in1,in2);
		FileOutputStream out=new FileOutputStream("temp/merge.txt");
		int len;
		while((len =in.read())!=-1)
			out.write(len);
		in.close();
		out.close();
	}
	@Test
	public void test2() throws IOException{
		// 合并多个文件, 使用Vector
		FileInputStream in1 = new FileInputStream("temp/1.txt");
		FileInputStream in2 = new FileInputStream("temp/2.txt");
		FileInputStream in3 = new FileInputStream("temp/merge.txt");
		
		Vector<InputStream> vector=new Vector<InputStream>();
		vector.add(in1);
		vector.add(in2);
		vector.add(in3);
		
		Enumeration<InputStream> e =vector.elements();
		SequenceInputStream in =new SequenceInputStream(e);
		FileOutputStream out=new FileOutputStream("temp/merge2.txt");
		
		int len;
		while((len =in.read())!=-1)
			out.write(len);
		in.close();
		out.close();			
	}
	@Test
	public void test3() throws IOException{
		// 合并多个文件, 使用自定义的Enumeration
		FileInputStream in1 = new FileInputStream("temp/1.txt");
		FileInputStream in2 = new FileInputStream("temp/2.txt");
		FileInputStream in3 = new FileInputStream("temp/merge.txt");
		
		ArrayList<InputStream> list = new ArrayList<InputStream>();
		list.add(in1);
		list.add(in2);
		list.add(in3);
		
		final Iterator<InputStream> iter =list.iterator();
		
		Enumeration<InputStream> e=new Enumeration<InputStream>(){

			public boolean hasMoreElements() {
				return iter.hasNext();
			}

			public InputStream nextElement() {
				return iter.next();
			}			
		};
		SequenceInputStream in =new SequenceInputStream(e);
		FileOutputStream out=new FileOutputStream("temp/merge3.txt");
		
		int len;
		while((len =in.read())!=-1)
			out.write(len);
		in.close();
		out.close();
	}
	
}
