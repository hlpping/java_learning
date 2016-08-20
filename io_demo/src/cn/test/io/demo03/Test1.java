package cn.test.io.demo03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
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
				String[] nameArr=dir.list();
				for(String s:nameArr){
					File f=new File(dir,s);
					
					if(f.isFile()&&(f.getName().endsWith(".java")||f.getName().endsWith(".class")) ){
						System.out.println(f.getName());
					}
				}
				break;				
			}
		}
		
	}
}
/*
1.接受用户输入一个文件夹路径, 显示出该路径下所有.java文件和.class文件名
需要判断用户输入路径是否存在, 不存在则提示
需要判断用户输入路径是否为文件夹, 不是文件夹则提示
如果存在, 且为文件夹, 那么显示.java文件和.class文件名

思路:
	先定义一个BufferedReader
	读取一行
	将读取到的一行封装成文件对象
	判断是否不存在
		如果不存在则提示
	判断是不是文件夹
		如果不是则提示
	如果是一个存在的文件夹
		遍历其所有子文件
			判断每一个文件是否是文件并且以.java或.class结尾
				如果是那么打印
*/