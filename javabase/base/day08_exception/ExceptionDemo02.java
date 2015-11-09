package base.day08_exception;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class ExceptionDemo02 {
	@Test
	public void test1(){
		System.out.println("程序开始运行");
		try{
			if(1==1)
				throw new ClassNotFoundException();
		}catch(ClassNotFoundException e){
			System.out.println("出异常了");
		}finally{
			System.out.println("一定会执行的代码");
		}
		System.out.println("程序开始结束");
	}

	@Test
	public void test2(){
		System.out.println("程序开始运行");
		try{
//			System.out.println(1/0);
			if(1==1)
				throw new ClassNotFoundException("找不到 Xxx 类");
			throw new NoSuchMethodException();
		}catch(ClassNotFoundException e){
			System.out.println("抛出了 ClassNotFoundException");	
			e.printStackTrace();	// 打印异常信息
		}catch(NoSuchMethodException e){
			System.out.println("抛出了 NoSuchMethodException");
		}catch(Exception e){
			// System.out.println("抛出了 Exception");	
			e.printStackTrace();
		}
		System.out.println("程序开始结束");
	}
}

/* 子类不能比父类抛出更多的异常 */
class Person {
	public void run() throws IOException {
		System.out.println("Person run..");
	}
}
class Student extends Person {
	public void run() throws FileNotFoundException {
		System.out.println("Student run..");
	}
}