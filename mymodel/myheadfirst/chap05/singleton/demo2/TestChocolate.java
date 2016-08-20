package chap05.singleton.demo2;

import org.junit.Test;

public class TestChocolate {
	@Test
	public void test1(){
		
		ChocolateBoiler boiler = ChocolateBoiler.getInstance();
		boiler.fill();
		boiler.boil();
		boiler.drain();

		// will return the existing instance
		ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();
	}
}
