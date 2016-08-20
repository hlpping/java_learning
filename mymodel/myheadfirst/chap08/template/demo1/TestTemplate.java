package chap08.template.demo1;

import org.junit.Test;

public class TestTemplate {
	
	@Test
	public void test1(){
		
		Tea tea = new Tea();
		Coffee coffee = new Coffee();
 
		System.out.println("\nMaking tea...");
		tea.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();
		
	}
}
