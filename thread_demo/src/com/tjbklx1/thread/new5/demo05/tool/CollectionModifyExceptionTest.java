package com.tjbklx1.thread.new5.demo05.tool;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionModifyExceptionTest {
	public static void main(String[] args) {
		Collection users = new CopyOnWriteArrayList();
			
			//new ArrayList();
		users.add(new User("张三",28));	
		users.add(new User("李四",25));			
		users.add(new User("王五",31));	
		Iterator itrUsers = users.iterator();
		while(itrUsers.hasNext()){
			System.out.println("aaaa");
			User user = (User)itrUsers.next();
			if("李四".equals(user.getName())){
				users.remove(user);
				//itrUsers.remove();
			} else {
				System.out.println(user);				
			}
		}
	}
}	
class User implements Cloneable{
	private String name;
	private int age;
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof User)) {
			return false;	
		}
		User user = (User)obj;
		//if(this.name==user.name && this.age==user.age)
		if(this.name.equals(user.name) 
			&& this.age==user.age) {
			return true;
		}
		else {
			return false;
		}
	}
	public int hashCode() {
		return name.hashCode() + age;
	}
	
	public String toString() {
		return "{name:'" + name + "',age:" + age + "}";
	}
	public Object clone()  {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {}
		return object;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
} 