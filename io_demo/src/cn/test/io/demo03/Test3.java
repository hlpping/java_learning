package cn.test.io.demo03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 3.接收用户输入一个文件夹路径, 将文件夹中所有文件及文件夹结构保存在一个文件中
		a).接收用户输入一个文件夹路径, 将这个路径下所有文件及文件夹的名字保存在list.txt中
		b).对子文件按等级缩进
 */
public class Test3 {
	public static void main(String[] args) throws IOException {
		File dir=GetDir.getDir();
		list(dir, 0);		
	}
	private static void list(File dir, int lv) throws IOException {
		File[] subFiles=dir.listFiles();
		if(subFiles!=null){
			for(File subfile : subFiles){				
				FileWriter writer=new FileWriter("list.txt",true);
				for(int i=0;i<lv;i++)	
					writer.write("\t");
				writer.write(subfile.getName()+"\r\n");
				writer.close();	
				if(subfile.isDirectory())
					list(subfile, lv+1);
				
			}			
		}		
	}
}
