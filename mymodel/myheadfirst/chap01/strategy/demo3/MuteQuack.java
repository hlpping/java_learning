package chap01.strategy.demo3;

public class MuteQuack implements QuackBehavior{

	public void quack() {
		System.out.println("<< Silence>>");
	}

}
