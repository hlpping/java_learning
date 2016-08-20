package chap07.adapter.demo1;

import org.junit.Test;

public class TestAdapter {
	
	@Test
	public void test1(){
		MallardDuck mallardDuck =new MallardDuck();
		WildTurkey wildTurkey =new WildTurkey();
		TurkeyAdapter turkeyAdapter =new TurkeyAdapter(wildTurkey);
		
		
		System.out.println("duck says:");
		mallardDuck.quack();
		mallardDuck.fly();
		
		System.out.println();
		
		System.out.println("turkey says:");
		wildTurkey.gobble();
		wildTurkey.fly();
		
		System.out.println();
		
		System.out.println("turkeyAdapter says:");
		turkeyAdapter.quack();
		turkeyAdapter.fly();
	}
}
