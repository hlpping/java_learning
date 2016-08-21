package cn.itcast.annocation.demo01;

@HelloWorld
public class TestBean {
	@HelloWorld
	private String name;
	
	@HelloWorld(name="sd")
	private String name02;
	
	@HelloWorld
	public String getName(){
		return name;
	}
	@HelloWorld
	public String getName02(){
		return name02;
	}
}
