package chap05.singleton.demo1;
/**
 * �ǵ�̬ ÿ��newһ������
 * @author shuang
 *
 */
public class MyClass {
	
	private MyClass(){}
	
	public static MyClass getInstance(){
		return new MyClass();
	}
}
