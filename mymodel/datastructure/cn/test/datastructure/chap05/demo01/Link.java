package cn.test.datastructure.chap05.demo01;

public class Link {

	public int iData;
	public double dData;
	public Link next;

	public Link(int id, double dd) {
		this.iData = id;
		this.dData = dd;
	}
	
	public void displayLink(){
		System.out.print("{"+iData+","+dData+"}");
	}
	
}
