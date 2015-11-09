package basestrong.unchangedparam;
/**
 * 
 * @author ˫
 * @vision Jun 15, 2011
 * 没有给 setter 方法
 */
public class Car {
	private String name;
	
	public Car(String name){
		this.name=name;
	}
	
	public String getCar(){
		return this.name;
	}
}
