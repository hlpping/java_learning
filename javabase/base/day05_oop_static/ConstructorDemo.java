package base.day05_oop_static;
/**
 * 关于构造方法
 * @author Administrator
 *
 */
public class ConstructorDemo {
	public static void main(String[] args) {
		Persons p =new Persons();
		p.show();
		Persons p2 =new Persons("zoo");
		p2.show();
		
	}
}
class Persons{
	private String name;
	private int grade;
	
	public Persons(){
		this("未录入",-1);
	}
	public Persons(String name){
		this(name,-1);
	}
	
	public Persons(String name, int grade){
		this.name = name;
		this.grade = grade;
	}
	public void show(){
		System.out.println(name + " : " + grade);
	}
}