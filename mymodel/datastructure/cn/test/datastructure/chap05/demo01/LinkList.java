package cn.test.datastructure.chap05.demo01;

public class LinkList {
	
	private Link first;
	
	public LinkList(){
		first = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	/**
	 * 新生成的元素,把数值付给新元素,把null付给新元素的next,同时把新元素付给first
	 * 
	 * 再次生成新元素,赋值,吧first付给新元素的next,同时把新元素付给first
	 * @param id
	 * @param dd
	 */
	public void insertFirst(int id,double dd){
		Link newLink = new Link(id, dd);
		newLink.next=first;
		first = newLink;
	}
	
	/**
	 * 找到first,吧first.next的引用付给当前元素
	 * @return
	 */
	public Link deleteFirst(){
		Link temp = first;
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
		
		LinkList list = new LinkList();
		list.insertFirst(22, 2.99);
		list.insertFirst(44, 4.99);
		list.insertFirst(66, 6.99);
		list.insertFirst(88, 8.99);
		
		list.displayList();
		
		while( !list.isEmpty()){
			Link alink = list.deleteFirst();
			System.out.print("Delete ");
			alink.displayLink();
			System.out.println();
		}
		list.displayList();
	}
	
}
