package base.day08_exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionDemo03 {
	public static void main(String[] args) throws IOException {
//		printFile("2.txt");
		test();
		
	}
	public static void test() throws IOException{
		System.out.println("请输入一个数字, 程序可以为您判断是奇数还是偶数: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = reader.readLine();
			try{
				int x = Integer.parseInt(line);
				System.out.println(x % 2 == 1 ? "奇数" : "偶数");
				break;
			}catch(NumberFormatException e){
				System.out.println("您输入的不是数字, 请重新输入: ");	
			}
		}
	}
	
	
	public static void printFile(String path) throws FileNotFoundException{		
		if("1.txt".equals(path)){
			System.out.println("这是 1.txt 的内容");
		}else {
//			throw new FileNotExistsException();
			
//			FileReader reader = new FileReader(path);
// 			throw new FileNotFoundException(path + " (系统找不到指定文件.)");
			throw new FileNotExistsException(path + " (系统找不到指定文件.)");			
		}		
	}
}
@SuppressWarnings("serial")
class FileNotExistsException extends RuntimeException{	
	public FileNotExistsException(){}
	
	public FileNotExistsException(String msg){		// 通过构造函数接收一个msg
		super(msg);		// 将这个msg传递给父类, 别人调用父类的printStackTrace()时, 就可以打印出msg了
	}	
}
