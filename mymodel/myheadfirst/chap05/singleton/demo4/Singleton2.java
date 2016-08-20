package chap05.singleton.demo4;

/**
 * ͬ��
 * 
 * @author shuang
 * 
 */
public class Singleton2 {
	private static Singleton2 uniqueInstance;

	private Singleton2() {
	}

	public static synchronized Singleton2 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton2();
		}
		return uniqueInstance;
	}
}