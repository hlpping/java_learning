package serialize_eg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class ObjectSaver {
	public static void main(String[] args) throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				"D:/objectFile.obj")); // 序列化对象
		Customer customer = new Customer("阿蜜果", 24);
		out.writeObject("你好!");
		out.writeObject(new Date());
		out.writeObject(customer);
		out.writeInt(123); // 写入基本类型数据
		out.close(); // 反序列化对象
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"D:/objectFile.obj"));
		System.out.println("obj1=" + (String) in.readObject());
		System.out.println("obj2=" + (Date) in.readObject());
		Customer obj3 = (Customer) in.readObject();
		System.out.println("obj3=" + obj3);
		int obj4 = in.readInt();
		System.out.println("obj4=" + obj4);
		in.close();
	}
}

class Customer implements Serializable {
	private String name;
	private int age;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "name=" + name + ", age=" + age;
	}
}