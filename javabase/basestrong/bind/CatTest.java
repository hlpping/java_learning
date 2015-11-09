package basestrong.bind;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CatTest {
	@Test
	/**
	 * @Test 方法必须是无参非静态方法 
	 * 只有多态才有绑定机制 
	 * 只有实例方法与对象绑定才叫 动态绑定 如 a.eat(); 
	 * 其他都是静态绑定 即  成员变量 静态方法与类型绑定 叫静态绑定
	 */
	public void maina() {
		Animal a = new Cat();
		a.run();
		a.eat();
		System.out.println(a.name);
		System.out.println(a.age);
	}
	// beforeClass AfterClass 方法必须是静态方法
	
	@BeforeClass
	public static void ab() {
		System.out.println("编译前");
	}

	@AfterClass
	public static void tt() {
		System.out.println("编译后");
	}

}
