package io.demo01;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import org.junit.Test;

public class Demo {
	
	//截取文件,根据起始点
	public static String read(File file,int from ,int to) throws IOException{
		 byte[] result2=new byte[to-from+1];
		 
		 FileInputStream fis =new FileInputStream(file);
		 BufferedInputStream bis=new BufferedInputStream(fis);
		 
		 bis.skip(from);
		 bis.read(result2, 0, to-from+1);
		 
		 fis.close();
		 bis.close();
		 return new String(result2);
	 }
	
	@Test
	public void test2() throws IOException {
		File file = new File("E:\\log.txt");
		LineNumberReader reader = new LineNumberReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter("e:\\a.txt"));

		String line;
		while ((line = reader.readLine()) != null) {
			if (line.contains("2011-10-30 18:02:37")) {
				writer.write(line + "\r\n");
			} else if (line.contains("2011-10-30 18:02:38")) {
				writer.flush();
			}
		}
		writer.close();
	}
	
	@Test
	public void test() throws IOException {
		File file = new File("E:\\log.txt");
		LineNumberReader reader = new LineNumberReader(new FileReader(file));

		String line;
		int fromLine = 0;
		int toLine = 0;
		while ((line = reader.readLine()) != null) {
			if (line.startsWith("2011-10-30 18:02:37")) {
				fromLine = reader.getLineNumber();
				break;
			}
		}
		while ((line = reader.readLine()) != null) {
			if (line.startsWith("2011-10-30 18:02:38")) {
				toLine = reader.getLineNumber();
				break;
			}
		}
		System.out.println(fromLine + "      " + toLine);
		read(fromLine, toLine, file);
	}

	public void read(int from, int to, File file) {
		LineNumberReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new LineNumberReader(new FileReader(file));
			writer = new BufferedWriter(new FileWriter("e:\\a.txt"));
			from = from - 1;
			to = to - 1;
			reader.skip(from);
			String line;
//			for (int i = 0; i < to - from && (line = reader.readLine()) != null; i++) {
////				if(reader.getLineNumber()==from)
//				writer.write(line + "\n");
//			}
			while((line = reader.readLine()) != null)
				if(reader.getLineNumber()>from&&reader.getLineNumber()<to ){
					writer.write(line + "\n");
									
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void queryByLine() throws FileNotFoundException, IOException {
		int[] lineArea =new int[]{1,20000};			
		File file = new File("e:\\TeotServer.log.2011-12-09-02");
		
		FileInputStream fInputStream =new FileInputStream(file);
		LineNumberReader reader=new LineNumberReader(new InputStreamReader(fInputStream));
		BufferedWriter writer =new BufferedWriter(new FileWriter("e:\\log.txt"));
		
		String line;
		while((line =reader.readLine())!=null){
			if(reader.getLineNumber()>=lineArea[0]){
				System.out.println(reader.getLineNumber()+"\t:"+line);
				writer.write(line);
			}
			if(reader.getLineNumber()==lineArea[1]){
				break;
			}
		}
		writer.close();
	}
	@Test
	public void test01() throws IOException {
		File file =new File("E:\\temp\\access.log00817");
		System.out.println(readFromTO(file,0 ,1000));		 

		
	}
	 public static String readFromTO(File file,int from ,int to) throws IOException{
		 byte[] result2=new byte[to-from+1];
		 
		 FileInputStream fis =new FileInputStream(file);
		 BufferedInputStream bis=new BufferedInputStream(fis);
		 
		 bis.skip(from);
		 bis.read(result2, 0, to-from+1);
		 
		 fis.close();
		 bis.close();
		 return new String(result2);
	 }
}
