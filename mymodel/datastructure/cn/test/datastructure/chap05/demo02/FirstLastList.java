package cn.test.datastructure.chap05.demo02;

public class FirstLastList {
	
	private Link first;
	private Link last;
	
	public FirstLastList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	/**
	 * 第一次赋值,将FirstLastList生成的第一个新元素first=null,last=newlink,newlink.next=null
	 * 将first= newlink
	 * 
	 * 第二次以后 ,生成的新元素
	 * @param dd
	 */
	public void insertFirst(long dd){
		Link newLink = new Link(dd);
		
		if( isEmpty())
			last = newLink;
		newLink.next=first;
		first = newLink;
	}
	
	public void insertLast(long dd){
		Link newLink = new Link(dd);
		
		if( isEmpty())
			first = newLink;
		else
			last.next=newLink;
		last = newLink;
	}
	
	public long deleteFirst(){
		long temp = first.dData;
		if(first.next == null)
			last = null;
		first = first.next;
		return temp;
	}
	
	public void displayList(){
		System.out.println("List(First-->last):");
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		FirstLastList list = new FirstLastList();
		list.insertFirst(22);
		list.insertFirst(44);
		list.insertFirst(66);
		
		list.insertLast(11);
		list.insertLast(33);
		list.insertLast(55);
		
		list.displayList();
		
		list.deleteFirst();
		list.deleteFirst();
		
		list.displayList();
	}
	
}
