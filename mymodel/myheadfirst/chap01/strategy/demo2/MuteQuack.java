package chap01.strategy.demo2;

public class MuteQuack implements QuackBehavior{

	public void quack() {
		System.out.println("<< Silence>>");
	}

}
