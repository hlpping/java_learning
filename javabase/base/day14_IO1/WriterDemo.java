package base.day14_IO1;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class WriterDemo {
	@Test
	public void test1(){
		FileWriter writer=null;
		try {
			writer =new FileWriter("tar_writer.txt");
			writer.write("母亲节快乐!/r/n");
			writer.write("母亲节快乐!/r/n");
			
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
	public void test2() throws IOException{
		FileWriter writer=null;
		try {
			writer =new FileWriter("tar_writer.txt");
			writer.write("母亲节快乐!/r/n");					
		
		} finally{			
				if(writer!=null)
					writer.close();			
		}		
	}
	@Test
	public void test3(){
		
	}
	
	
}
