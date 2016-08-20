package cn.test.io.demo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import org.junit.Test;

public class Demo01_Reader_and_Writer {
	
	@Test
	public void testReader(){
		FileReader reader =null;
		try {
			reader =new FileReader("input\\source.txt");
			int ch ;
			while((ch=reader.read())!=-1){
				System.out.print((char)ch);
			}		
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
				try {
					if(reader!=null)
						reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}			
		}
	}
	@Test
	public void testWriter(){
		// 在创建FileWriter的时候, 查找关联文件是否存在, 存在的话会删除, 直接创建一个log.txt
		// 如果指定append参数, 参数为true则在原文件上追加, false则覆盖
		FileWriter writer=null;
		try {
//			writer =new FileWriter("output\\writer.txt");
			writer =new FileWriter("output\\writer.txt",true);
			writer.write("母亲节快乐!\\r\\n");
			writer.write("母亲节快乐!\\r\\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(writer!=null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	@Test
	public void testCopyFile() throws IOException{
		
		FileReader reader=new FileReader("input\\source.txt");
		FileWriter writer=new FileWriter("output\\writer.txt"); 
		
		char[] buf =new char[1024];
		int len;
		len =reader.read(buf);
		writer.write(buf, 0, len);
				
		reader.close();
		writer.close();		
	}
	
	@Test
	public void testBufferedReader() throws IOException{
		//读取一行
		FileWriter writer =new FileWriter("output\\log.txt");
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line =reader.readLine();
			writer.write(line);
			writer.close();
		}
	}
	
	@Test
	public void testLineNumberReader() throws IOException {
		LineNumberReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new LineNumberReader(new FileReader("input\\source.txt"));
			writer = new BufferedWriter(new FileWriter("output\\dest.txt"));
			String line;
			while ((line = reader.readLine()) != null)
				writer.write(reader.getLineNumber() + ":" + line + "\r\n");
		} finally {
			CloseUtil.close(reader, writer);
		}
	}
}
