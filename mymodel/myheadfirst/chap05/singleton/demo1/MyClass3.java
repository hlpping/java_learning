package chap05.singleton.demo1;
/**
 * ��������,�Զ���������.
 * @author shuang
 *
 */
public class MyClass3 {

	private MyClass3() {
	}

	private static MyClass3 uniqueInstance = new MyClass3();

	public static MyClass3 getInstance() {
		return uniqueInstance;
	}
}
