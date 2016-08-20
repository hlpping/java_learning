package cn.test.io.demo03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class FileApiTest {
	@Test
	public void test1(){
		File f1 = new File("a.jpg"); // 相对路径, 如果用Eclipse运行, 那么相对于工程根目录. 如果用cmd.exe运行, 那么找的是bin目录下. ClassLoader
		File f2 = new File("D:/ItCast/20110419/day16/src/a.txt"); // 文件的绝对路径
		File f3 = new File("test"); // 指向一个文件夹
		File f4 = new File("D:/ItCast/20110419/day16/test");
		File f5 = new File("abc");
		
		System.out.println(f1.getAbsolutePath());
		System.out.println(f1.exists());

		System.out.println(f2.getAbsolutePath());
		System.out.println(f2.exists());

		System.out.println(f3.getAbsolutePath());
		System.out.println(f3.exists());

		System.out.println(f4.getAbsolutePath());
		System.out.println(f4.exists());

		System.out.println(f5.getAbsolutePath());
		System.out.println(f5.exists());
	}
	@Test
	public void test2(){
		File f1 = new File("a.jpg");
		File f2 = new File("src");

		System.out.println(f1.isFile());
		System.out.println(f2.isFile());

		System.out.println(f1.isDirectory());
		System.out.println(f2.isDirectory());		
	}
	@Test
	public void test3(){
		File f1 = new File("test1/b.jpg");
		File f2 = new File("test");
		System.out.println(f1.compareTo(f2)); // 比较的是路径名字符串的字典顺序
	}
	@Test
	public void test4() throws IOException{
		File f1 = new File("newFile.txt");
		f1.createNewFile();
	}
	@Test
	public void test5(){
		File f1 = new File("newFile.txt");
		System.out.println(f1.delete()); // 删除文件, 如果删除成功, 返回true

		File f2 = new File("test");
		System.out.println(f2.delete()); // 删除文件夹时, 如果其中包含文件或文件夹, 那么不能删除
	}
	@Test
	public void test6(){
		File file = new File("test/a");
		file.deleteOnExit(); // 在退出程序时删除, 如果有文件, 那么删不掉
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());		
	}
	@Test
	public void test7(){
		File f1 = new File("src/a.txt");
		File f2 = new File("D:/ItCast/20110419/day16/src/a.txt");
		File f3 = new File("D:/ItCast/20110419/day16/src/a.txt");
		System.out.println(f1.equals(f2));
		System.out.println(f2.equals(f3));		
	}
	@Test
	public void test8(){
		File f1 = new File("test1/b.jpg");
		File f2 = f1.getParentFile(); // 获取父级文件夹, 是从File对象封装的字符串路径截取的, 如果是相对路径的根目录, 会获取不到
		File f3 = f1.getAbsoluteFile(); // 获取f1的绝对路径, 使用这个路径封装成一个File对象
		System.out.println(f2.exists());
		System.out.println(f2.getAbsolutePath());		
	}
	@Test
	public void test9(){
		File f1 = new File("test1/b.jpg");
		File f2 = new File("abc");	
		System.out.println(f1.getName());
		System.out.println(f2.getName());	
		
		System.out.println(f1.length()); // 获取文件大小
		System.out.println(f2.length()); // 文件夹没有大小
	}
	@Test
	public void test10(){
		File f1 = new File("test1/b.jpg");
		System.out.println(f1.getParent());
		File f2 = f1.getParentFile(); // 获取父级路径, 用这个路径封装成一个文件
		System.out.println(f2.getAbsolutePath());	
		
		System.out.println(f1.getTotalSpace()); // 获取当前盘符总空间
		System.out.println(f1.getUsableSpace()); // 虚拟机可用
		System.out.println(f1.getFreeSpace()); // 未使用
		
		System.out.println(f1.isAbsolute());
		// 获取最后修改时间, 从1970年1月1日0时到最后一次修改时的毫秒数
		System.out.println(f1.lastModified()); 
	}
	@Test
	public void test11(){
//		File f1 = new File("abc");
		File f1 = new File("abc/xxx");
		boolean b = f1.mkdir(); // 创建文件夹, 如果存在就不创建返回false, 如果不存在就创建返回true, 如果父级目录不存在也返回false
		System.out.println(b);
		// createNewFile是创建文件, mkdir是创建文件夹
	}	
	
	/*
	 * 打印出一个指定文件夹下所有的文件名
	 */
	@Test
	public void test12(){
		File dir = new File("E:/workspace/BaseStudy");
		printSubFiles(dir);
		
	}
	public static void printSubFiles(File dir){
		dir = new File("E:/workspace/BaseStudy");
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
	public void test14(){
		// 某些系统文件不能获取子文件, 使用listFiles()方法会返回null, 这时如果传入增强for循环, 会抛出空指针异常

		File file = new File("D:/Recycled");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.listFiles()); 
		// 有的系统上, listFiles()方法会返回null		
	}
	
}
