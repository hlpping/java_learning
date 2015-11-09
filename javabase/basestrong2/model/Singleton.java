package basestrong2.model;
/**
 *	单态
 */
public class Singleton {
	public static void main(String[] args) {
		
		Teacher t1=Teacher.getInstance();
		Teacher t2=Teacher.getInstance();
		
		System.out.println(t1==t2);
	}
}
class Teacher{
	final private static Teacher teacher =new Teacher();
	private Teacher(){}
	
	public static Teacher getInstance(){
		return teacher;
	}
}
