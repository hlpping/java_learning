package cn.test.datastructure.chap05.demo06;

public class Link {

	public long dData;
	public Link next;

	public Link(long dd) {
		this.dData = dd;
	}
	
	public void displayLink(){
		System.out.print( dData+"}" );
	}
	
}
