package cn.test.io.demo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CopyFileDemo {
	
	long time = 0;
	String input ="input\\src.txt";
	String output ="output\\src.txt";
	@Before
	public void setUp() {
		time = System.currentTimeMillis();
	}
	
	@After
	public void tearDown(){
		time = System.currentTimeMillis()-time;
		System.out.println(time);
	}
	
	//method1:int ch
	@Test
	public void copyByInt(){
		FileReader reader=null;
		FileWriter writer=null;
		
		try {
			reader =new FileReader(input);
			writer =new FileWriter(output);
			
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
	@Test
	public void copyByArray(){
		FileReader reader=null;
		FileWriter writer=null;
		
		try {
			reader =new FileReader(input);
			writer =new FileWriter(output);
			
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
	@Test
	public void copyByBuffered(){
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(input)); // 创建一个BufferedReader, 需要传入一个Reader
			writer = new BufferedWriter(new FileWriter(output)); // 创建一个BufferedWriter, 需要传入一个Writer
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
	@Test
	public void copyByBufferedReadLine(){
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(input)); // 创建一个BufferedReader, 需要传入一个Reader
			writer = new BufferedWriter(new FileWriter(output)); // 创建一个BufferedWriter, 需要传入一个Writer
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
