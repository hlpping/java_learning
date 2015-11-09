package base.day16_IO3_file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

/*
 * 4.拷贝文件夹
		接收用户输入两个文件夹路径, 将第一个文件夹路径下所有子文件和文件夹拷贝到第二个路径下
		拷贝的时候, 给所有.java和.txt文件加上行号
 */
public class Test4 {
	public static void main(String[] args) throws IOException {
		// 调用工具方法接收两个文件夹路径, 封装成两个文件对象
		File src = GetDir.getDir();
		File dest = GetDir.getDir();

		// 调用拷贝文件夹方法
		copyDir(src, dest);		
	}

	private static void copyDir(File src, File dest) throws IOException {
		File destDir =new File(dest,src.getName());
		if(!destDir.exists()){
			destDir.mkdir();
		}
		File[] srcFiles=src.listFiles();
		if(srcFiles!=null){
			for(File srcFile: srcFiles){
				if(srcFile.isDirectory())
					copyDir(srcFile, destDir);
				else
					copyFile(srcFile, destDir); // 如果是文件, 拷贝
			}			
		}		
	}

	private static void copyFile(File src, File dest) throws IOException {		
		if (src.getName().endsWith(".java") || src.getName().endsWith(".txt")) {
			LineNumberReader reader = new LineNumberReader(new FileReader(src));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(dest, src.getName())));
			String line;
			while ((line = reader.readLine()) != null)
				writer.write(reader.getLineNumber() + ":" + line + "\r\n");
			reader.close();
			writer.close();
		} else {
			BufferedInputStream in =new BufferedInputStream(new FileInputStream(src));
			BufferedOutputStream out =new BufferedOutputStream(new FileOutputStream(new File(dest,src.getName())));
			
			int b;
			while((b=in.read())!=-1)
				out.write(b);
			in.close();
			out.close();
		}
	}
}
