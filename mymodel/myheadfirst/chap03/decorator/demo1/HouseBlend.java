package chap03.decorator.demo1;
/**
 * HouseBlend �ۺϿ���
 * @author shuang
 *
 */
public class HouseBlend extends Beverage {
	
	public HouseBlend(){
		description ="House Blend Coffee";
	}
	
	@Override
	public double cost() {
		return 0.89;
	}

}
