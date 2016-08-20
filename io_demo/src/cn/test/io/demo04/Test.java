package cn.test.io.demo04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Test {

	/*
	 * 1.接受用户输入一个文件路径, 将此路径对应的文件分割成10份保存在D盘根目录下的一个文件夹中
	 * 		例如: 
	 * 			用户输入 D:\music\迈克尔·杰克逊 - Breaking News（突发新闻）.mp3
	 * 			就以文件名命名一个文件夹, 将所有子文件保存
	 * 2.接受用户输入一个文件夹路径, 将文件夹中所有文件合并
	 * 		例如:
	 * 			用户输入 D:\迈克尔·杰克逊 - Breaking News（突发新闻）.mp3
	 * 			那么就使用文件夹的名字命名一个文件
	 */
	public static void main(String[] args) throws IOException {
		//		cut();
		merge();
	}

	public static void merge() throws IOException {
		System.out.println("请输入要合并文件的文件夹, 程序将其合并成一个文件:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		File srcDir = new File(line); // 获取用户输入的路径指向的文件夹

		File[] subFiles = srcDir.listFiles(); // 获取所有子文件

		Vector<InputStream> vector = new Vector<InputStream>();
		for (File subFile : subFiles) {
			FileInputStream fis = new FileInputStream(subFile); // 定义输入流指向这些文件
			vector.add(fis); // 将这些输入流装入一个Vector
		}

		Enumeration<InputStream> e = vector.elements(); // 获取Vector的Enumeration

		SequenceInputStream sis = new SequenceInputStream(e); // 将Enumeration传入SequenceInputStream
		BufferedInputStream in = new BufferedInputStream(sis); // 由于直接使用sis逐个读取效率低, 所以包装, 提供缓冲功能.
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(srcDir, srcDir.getName())));

		int b;
		while ((b = in.read()) != -1)
			out.write(b);

		in.close();
		out.close();
	}

	public static void cut() throws IOException {
		System.out.println("请输入一个文件路径, 程序将会将其分割成10份:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		File srcFile = new File(line); // 获取到用户输入路径指向的文件

		File destDir = new File("D:/", srcFile.getName());
		destDir.mkdir(); // 在D盘根目录创建一个同名文件夹

		long subLen = (srcFile.length() + 9) / 10;
		int fileNum = 1;

		BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcFile)); // 从源文件中读取
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(destDir, fileNum + ""))); // 写出到指定目录下的子文件中

		int b;
		int len = 0;
		while ((b = in.read()) != -1) {
			out.write(b);
			if (++len == subLen) {
				out.close();
				out = new BufferedOutputStream(new FileOutputStream(new File(destDir, ++fileNum + "")));
				len = 0;
			}
		}

		in.close();
		out.close();
	}
}
