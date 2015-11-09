package basestrong.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CatCloneDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//克隆方法的测试
//		Cat c1=new Cat("baby","red");
//		System.out.println(c1);
//		Cat c2=(Cat)c1.clone();
//		System.out.println(c2);
//		System.out.println(c1==c2);	
		
		//序列化及反序列化
//		Cat c =new Cat("aaaaaaa","blue");		
//		ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream("e:/a"));
//		out.writeObject(c);
//		out.close();
		
		ObjectInputStream in =new ObjectInputStream(new FileInputStream("e:/a"));
		Object o =in.readObject();
		System.out.println(o);
		in.close();
		
		
	}

}
