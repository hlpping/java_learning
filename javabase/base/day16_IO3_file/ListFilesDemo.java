package base.day16_IO3_file;

import java.io.File;

import org.junit.Test;

public class ListFilesDemo {
	
	/*
	 * 打印出一个指定文件夹下所有的文件名
	 */
	@Test
	public void test1(){
//		File dir = new File("E:/workspace/BaseStudy");
//		printSubFiles(dir);
		
	}
	public static void printSubFiles(File dir){
		File[] subFiles=dir.listFiles();
		for(File subFile: subFiles){
			if(subFile.isFile())
				System.out.println(subFile.getName());			
			if(subFile.isDirectory())
				printSubFiles(subFile);	//递归调用 自己调用自己
		}		
	}
	@Test
	public void listJavaFile(){
		File file = new File("E:/workspace/BaseStudy/src/day03");
		String[] list=file.list();
		for(String s : list){
			File f=new File(file,s);
			if(f.isFile()&&s.endsWith(".java"))
				System.out.println(s);			
		}
	}
	@Test
	public void test2(){
		// 某些系统文件不能获取子文件, 使用listFiles()方法会返回null, 这时如果传入增强for循环, 会抛出空指针异常

		File file = new File("D:/Recycled");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.listFiles()); 
		// 有的系统上, listFiles()方法会返回null		
	}
	@Test
	public void test16(){}
}
