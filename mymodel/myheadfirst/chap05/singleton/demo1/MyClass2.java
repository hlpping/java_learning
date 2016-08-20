package chap05.singleton.demo1;
/**
 * ������ ֻ��û��ʱ�Ŵ�������
 * @author shuang
 *
 */
public class MyClass2 {

	private MyClass2() {
	}

	private static MyClass2 uniqueInstance;

	public static MyClass2 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new MyClass2();
		}
		return uniqueInstance;
	}
}
