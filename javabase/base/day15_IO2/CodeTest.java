package base.day15_IO2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

public class CodeTest {
	
	@Test
	public void test1() throws IOException{
		FileInputStream in =new FileInputStream("source.txt");
		int b;
		while((b=in.read())!=-1){
			if((byte)b<0){
				byte b1=(byte)b;
				byte b2=(byte)in.read();
				byte[] arr =new byte[]{b1,b2};
				System.out.print(new String(arr));
			}else
				System.out.print((char)b);
		}
		in.close();		
	}
	@Test
	public void test2() throws IOException{
		FileReader reader =new FileReader("source.txt");
		int ch;
		while((ch=reader.read())!=-1)
			System.out.print((char)ch);
		reader.close();
	}
	@Test
	public void test3() throws IOException{
		FileOutputStream out =new FileOutputStream("test.txt");
		out.write("sdfh受到官方机构大举".getBytes());
		out.close();
	}
	@Test
	public void test4() throws IOException{
		FileWriter writer=new FileWriter("test.txt");
		writer.write("玛利亚");
		writer.close();		
	}
	@Test
	public void test5(){
		
	}
	@Test
	public void test(){
		
	}
}
