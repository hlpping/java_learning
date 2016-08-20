package chap08.template.demo1;

public class Tea extends CaffeineBeverage{

	@Override
	void addCondiments() {
		// TODO Auto-generated method stub
		System.out.println("add lemon into tea");
	}

	@Override
	void brew() {
		// TODO Auto-generated method stub
		System.out.println("Steeping the tea");
	}

}
