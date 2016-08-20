package chap03.decorator.demo1;
/**
 * Beverage ����
 * @author shuang
 *
 */
public abstract class Beverage {
	String description = "Unkonwn Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}
