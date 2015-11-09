package base.day16_IO3_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {
	public static void main(String[] args) throws IOException {
		System.out.println("请输入一个文件夹路径:");
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line=reader.readLine();	
			if ("quit".equals(line))
				break;
			File dir =new File(line);			
			if(! dir.exists()){
				System.out.println("你输入的路径不存在,请重新输入, 退出输入quit:");
				break;
			}else if(!dir.isDirectory()){
				System.out.println("输入的不是文件夹路径, 请重新输入, 退出输入quit:"); 
			}else{
				copyJavaFile(dir); // 如果是一个存在的文件夹, 调用拷贝方法, 传入接收到的目录
				break;		
			}
		}		
	}

	private static void copyJavaFile(File dir) throws IOException {
		String[] nameArr =dir.list();
		for(String s:nameArr){
			File subFile=new File(dir,s);
			if(subFile.isDirectory())
				copyJavaFile(subFile);
			else if(subFile.getName().endsWith(".java"))
				copy(subFile); // 那么拷贝文件到Java文件夹下
		}		
	}

	private static void copy(File file) throws IOException {
		FileInputStream in =new FileInputStream(file);
		File dir =new File("e:/xxx",file.getName());
		FileOutputStream out =new FileOutputStream(dir);
		
		byte[] buf=new byte[1024];
		int len;
		while((len =in.read(buf))!=-1){
			out.write(buf,0,len);
		}
		in.close();
		out.close();
	}
	
}
/*
2.接受用户输入一个文件夹路径, 将该路径下所有.java文件拷贝到Java文件夹中
先定义一个BufferedReader
	读取一行
	将读取到的一行封装成文件对象
	判断是否不存在
		如果不存在则提示
	判断是不是文件夹
		如果不是则提示
	如果是一个存在的文件夹
		调用拷贝方法, 传入接收到的目录
		
拷贝方法:
	获取目录下所有子文件
	遍历所有子文件
		如果是文件夹
			递归调用
		如果是文件
			那么拷贝文件到Java文件夹下
*/