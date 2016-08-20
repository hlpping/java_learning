package chap08.template.demo1;

public abstract class CaffeineBeverage {
	
	final void prepareRecipe(){
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	abstract void addCondiments() ;
	abstract void brew() ;
	
	private void pourInCup() {
		// TODO Auto-generated method stub
		System.out.println("pour into cup ...");
	}

	private void boilWater() {
		// TODO Auto-generated method stub
		System.out.println("boiling water ....");
	}
	
	
	
}
