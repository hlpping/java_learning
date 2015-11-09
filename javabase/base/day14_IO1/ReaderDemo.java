package base.day14_IO1;

import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;

public class ReaderDemo {
	@Test
	public void test1(){
		FileReader reader =null;
		try {
			reader =new FileReader("source.txt");
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
	public void test2() throws IOException{
		FileReader reader =null;
		try{
			reader =new FileReader("source.txt");
			int ch ;
			while((ch=reader.read())!=-1){
				System.out.print((char)ch);
			}
		} finally{
			if(reader!=null){
				reader.close();
			}
		}
	}
	
}
