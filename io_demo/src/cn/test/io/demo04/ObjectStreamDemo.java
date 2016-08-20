package cn.test.io.demo04;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class ObjectStreamDemo {
	
	@Test
	public void write() throws FileNotFoundException, IOException{
		User user1 = new User("Don", "123", "donfoo@donfoo.com");
		User user2 = new User("zs", "123", "zs@gmail.com");
		User user3 = new User("ls", "123", "ls@hotmail.com");
		// 对象输出流, 可以写出一个对象
		ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream("temp/stu.txt"));
		out.writeObject(user1); // 将对象写出, 将对象转成二进制字节写出
		out.writeObject(user2);
		out.writeObject(user3);
		out.close();
	}
	@Test
	public void read() throws IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("temp/stu.txt"));
		User user1 = (User) in.readObject(); // 从文件中读取一个对象, 从二进制数据转回对象, 返回Object类型
		User user2 = (User) in.readObject();
		User user3 = (User) in.readObject();
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		in.close();		
	}
	@Test
	public void loop() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("temp/stu.txt"));
		try {
			while (true) {
				User user = (User) in.readObject();
				System.out.println(user);
			}
		} catch (EOFException e) {
		}
		in.close();
	}
	
}
