package base.day14_IO1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class CopyFileDemo {
	@Test
	public void test(){
		long start =System.currentTimeMillis();
//		copy();
//		copyByArray();
		
//		copyByBuffered();
		copyByBufferedReadLine();
		
		long end =System.currentTimeMillis();		
		System.out.println(end-start);
	}
	//method1:int ch
	public static void copy(){
		FileReader reader=null;
		FileWriter writer=null;
		
		try {
			reader =new FileReader("source.txt");
			writer =new FileWriter("target.txt");
			
			int ch ;
			while((ch=reader.read())!=-1)
				writer.write(ch);			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			CloseUtil.close(reader, writer);
		}		
	}
	//method2:new char[1024]
	public static void copyByArray(){
		FileReader reader=null;
		FileWriter writer=null;
		
		try {
			reader =new FileReader("source.txt");
			writer =new FileWriter("target2.txt");
			
			char[] buf =new char[1024];
			int len;
			while((len=reader.read(buf))!=-1)
				writer.write(buf,0,len);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			CloseUtil.close(reader, writer);
		}
	}
	//method3: buffered 
	// 使用BufferedReader读取一个字符, 是从底层流(FileReader)中读取8192个, 然后返回给程序一个. 其他的用来缓冲, 下次再读时就不从文件中读了, 直接从缓冲区中返回
	// 使用BufferedWriter写出一个字符, 是先写到缓冲区中, 直到缓冲区写满8192个, 才真正使用底层流FileWriter写出到文件
	public static void copyByBuffered(){
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader("source.txt")); // 创建一个BufferedReader, 需要传入一个Reader
			writer = new BufferedWriter(new FileWriter("target3.txt")); // 创建一个BufferedWriter, 需要传入一个Writer
			int ch;
			while ((ch = reader.read()) != -1)
				writer.write(ch);
		} catch(IOException e){ 
			e.printStackTrace();
		} finally {
			CloseUtil.close(reader, writer);
		}
	}
	//method4 readline
	public static void copyByBufferedReadLine(){
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader("source.txt")); // 创建一个BufferedReader, 需要传入一个Reader
			writer = new BufferedWriter(new FileWriter("target4.txt")); // 创建一个BufferedWriter, 需要传入一个Writer
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line); // 一次读取一行, 将一行写出
				writer.newLine(); // 输出"\r\n"
			}
		} catch(IOException e){ 
			e.printStackTrace();
		} finally {
			CloseUtil.close(reader, writer);
		}		
	}
	
	
}
