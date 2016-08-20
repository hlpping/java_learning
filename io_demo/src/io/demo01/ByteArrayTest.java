package io.demo01;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

import org.junit.Test;

public class ByteArrayTest {
	
	String filename = "E:/temp/access.log00817";
	
	@Test
	public void test01() throws IOException {
//		FileInputStream in = new FileInputStream("E:\\log.txt");
		
		byte[] buf =new byte[1024];
		ByteArrayInputStream in = new ByteArrayInputStream(buf);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		int b;
		while ((b = in.read()) != -1)
			out.write(b); // 从文件中读取, 先保存到内存中
		in.close();

		byte[] arr = out.toByteArray(); // 从内存中获取所有写入的数据
		String s=Arrays.toString(arr);
		int beginIndex=s.indexOf("2011-10-30 18:02:37");
		int endIndex=s.indexOf("2011-10-30 18:02:38");
		System.out.println(beginIndex+"    "+endIndex);
		
		
		FileOutputStream fos = new FileOutputStream("E:\\a.txt");
		   
		fos.write(arr); // 将整个数组一次性写出到文件
		fos.close();
		
	}
	@Test
	public void testRandom() throws IOException{
		File file =new File(filename);
		RandomAccessFile f=new RandomAccessFile(file, "r");
		long startPos=0;
		long endPos=0;
		String line;
		while((line=f.readLine())!=null){
			if (line.contains("119.48.176.126"))
				startPos=line.indexOf("119.48.176.126");
		
			if (line.contains("14.146.57.98"))
				endPos=line.indexOf("14.146.57.98");
		}
		f.close();
		System.out.println(startPos+"   "+endPos);
	}
	
	@Test
	public void testByte() throws IOException {
		FileInputStream in = new FileInputStream(new File(filename));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		while (in.read(buf) != -1) {
			if (buf.toString().contains("2011-10-30 18:02:37")) {
				in.mark(0);
				out.write(buf);
				if (buf.toString().contains("2011-10-30 18:02:38")) {
					out.flush();
					break;
				}
			}
		}
		byte[] dest = out.toByteArray();
		FileOutputStream fos = new FileOutputStream("e:\\a.txt");
		fos.write(dest); // 将整个数组一次性写出到文件
		fos.close();

	}

	@Test
	public void testByte2() throws IOException {
		File file =new File("e:\\log.txt");
		/* 读取文件 */
		FileInputStream in = new FileInputStream(file);

		byte[] filebyte = new byte[(int) file.length()];
		String filecontent = new String(filebyte);
		byte[] buf =new byte[1024];
		int beginindex=0;
		int endindex=0;
		while(in.read(filebyte)!=-1){
		/* 以下开始寻找需要的内容 */
			beginindex = filecontent.indexOf("2011-10-30 18:02:37");
			endindex = filecontent.indexOf("2011-10-3 18:02:38");
		}
		System.out.println(beginindex+"     "+endindex);
		System.out.println(filecontent.substring(beginindex, endindex));
	}
	
	@Test
	public void testByte3() throws IOException {
		File file =new File("e:\\log.txt");
		/* 读取文件 */
		RandomAccessFile myfile =new RandomAccessFile(file, "r");

		byte[] filebyte = new byte[(int) file.length()];
		String filecontent = new String(filebyte);
		byte[] buf =new byte[1024];
		int beginindex=0;
		int endindex=0;
		while(myfile.read(filebyte)!=-1){
		/* 以下开始寻找需要的内容 */
			beginindex = filecontent.indexOf("2011-10-30 18:02:37");
			endindex = filecontent.indexOf("2011-10-3 18:02:38");
		}
		System.out.println(beginindex+"     "+endindex);
		System.out.println(filecontent.substring(beginindex, endindex));
	}

	
}
