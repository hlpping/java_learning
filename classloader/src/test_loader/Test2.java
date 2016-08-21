package test_loader;

import java.util.Random;

class FinalTest {
	// public static int x = 6 / 3;
	// public static final int x = 6 / 3;
	public static final int x = new Random().nextInt(100);

	static {
		System.out.println("FinalTest static block");
	}
}

public class Test2 {
	public static void main(String[] args) {
		System.out.println(FinalTest.x);
	}
}
