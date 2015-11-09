package basestrong.bind;

public class Animal {
	//成员变量 和静态成员变量
	public String name="animal";
	public static String age="8888";
	
	//非静态方法
	public void eat(){
		System.out.println("animal....eat.....");
	}
	//静态方法
	public static void run(){
		System.out.println("animal....running.....");
	}
	
}
