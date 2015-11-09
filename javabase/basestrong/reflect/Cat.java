package basestrong.reflect;

import java.io.Serializable;

public class Cat implements Serializable{
				//implements Cloneable{
	private String name;
	private String skin;
	
	public Cat(String name,String skin){
		this.name=name;
		this.skin=skin;
		System.out.println("运行构造方法");
	}
	public String toString(){
		return name+":"+skin;
	}
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}
