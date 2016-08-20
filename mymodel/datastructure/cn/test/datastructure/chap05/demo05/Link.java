package cn.test.datastructure.chap05.demo05;

public class Link {

	public long dData;
	public Link next;
	public Link previos;

	public Link(long dd) {
		this.dData = dd;
	}
	
	public void displayLink(){
		System.out.print(dData+" ");
	}
	
}
