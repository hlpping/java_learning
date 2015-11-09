package basestrong.unchangedparam;
/**
 * 
 * @author ˫
 * @vision Jun 15, 2011
 * 本程序是考察不可变参数的
 * 定义一个final 型的数组 并且将新传入的数组拷贝给自己数组
 */

public class Grade {
	private final String[] student;
	
	public Grade(String[] stu){
		student=new String[stu.length];
		for(int i =0;i<student.length;i++)
			student[i]=stu[i];
	}
	
	public void call(){
		for(String s: student)
			System.out.println(s);
	}
}
