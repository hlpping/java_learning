package chap03.decorator.demo1;
/**
 * Ũ������
 * @author shuang
 *
 */
public class Espresso extends Beverage {
	
	public Espresso(){
		description ="Espresso";
	}
	
	@Override
	public double cost() {
		return 1.99;
	}

}
