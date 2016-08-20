package chap08.template.demo1;

public class Coffee extends CaffeineBeverage{

	@Override
	void addCondiments() {
		// TODO Auto-generated method stub
		System.out.println("add suger and milk ");
	}

	@Override
	void brew() {
		// TODO Auto-generated method stub
		System.out.println("dripping coffee through filter");
	}

}
