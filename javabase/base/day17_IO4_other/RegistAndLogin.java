package base.day17_IO4_other;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.Test;

/*
 * 注册: 
 * 		提示用户输入用户名, 密码, 邮箱.
 * 		将数据封装成一个User对象
 * 		从文件中读取所有对象, 逐一使用getName()来equals比较, 判断是否有用户名相同的对象
 * 		如果有相同对象, 那么提示用户重复, 重新输入
 * 		如果没有相同的对象, 那么存入文件
 * 登录:
 * 		提示用户输入用户名, 密码
 * 		将数据封装成一个User对象
 * 		从文件中读取所有对象, 先比较用户名.
 * 		如果没有用户名相同的, 那么提示用户名不存在, 重新输入.
 * 		如果用户名存在, 那么比较密码.
 * 		如果密码不同, 提示密码错误, 重新输入.
 * 		如果密码相同, 提示登录成功.
 * 		outer:
 * 		break outer;
 * 将User装入一个ArrayList, 将ArrayList写入文件
 */
public class RegistAndLogin {
	@Test
	public void regist() throws IOException, ClassNotFoundException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		
		outer:while(true){			
				System.out.println("请输入用户名:");
				String name = reader.readLine();
				System.out.println("请输入密码:");
				String password = reader.readLine();
				System.out.println("请输入邮箱:");
				String email = reader.readLine();
				
				User newUser=new User(name,password,email);
				
				ObjectInputStream in =null;
				
				in=new ObjectInputStream(new FileInputStream("user.txt"));
				ArrayList<User> list =(ArrayList<User>)in.readObject();
				for (User user : list) {
					if (user.getName().equals(newUser.getName())) { // 遍历List, 判断以前存储的user是否有和新user名字相同的, 如果有, 重新输入
						System.out.println("用户名已存在, 请重新输入:");
						continue outer;
					}
				}
				list.add(newUser);
				ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("user.txt"));
				out.writeObject(list);
				out.close();
				System.out.println("注册成功");
				break outer;
				
		}
	}
	@Test
	public void login(){
		
	}
	
}
