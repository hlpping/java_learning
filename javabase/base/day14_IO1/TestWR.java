package base.day14_IO1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class TestWR {
	public static void main(String[] args) throws IOException {
		FileReader reader=new FileReader("source.txt");
		FileWriter writer=new FileWriter("tar_writer.txt"); 
		
		char[] buf =new char[1024];
		int len;
		len =reader.read(buf);
		writer.write(buf, 0, len);
				
		reader.close();
		writer.close();		
	}
	@Test
	public void test1() throws IOException{
		//读取一行
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line =reader.readLine();
			FileWriter writer =new FileWriter("log.txt");
			writer.write(line);
			writer.close();
		}
	}
	@Test
	public void test2() throws IOException{
		// 在创建FileWriter的时候, 查找关联文件是否存在, 存在的话会删除, 直接创建一个log.txt
		// 如果指定append参数, 参数为true则在原文件上追加, false则覆盖
		
		FileWriter writer = new FileWriter("log.txt", true);
		writer.write("第二12次的内容.");
		writer.close();
	}
}
