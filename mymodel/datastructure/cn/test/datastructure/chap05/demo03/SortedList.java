package cn.test.datastructure.chap05.demo03;

import cn.test.datastructure.chap05.demo02.Link;

public class SortedList {
	
	private Link first;
	
	public SortedList(){
		first = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public Link remove(){
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
	
	public void insert(long key){
		Link newLink = new Link(key);
		Link previous = null;
		Link current = first;
		
		while(current != null && key>current.dData){
			previous = current;
			current = current.next;
		}
		if(previous == null)
			first = newLink;
		else
			previous.next = newLink;
		newLink.next = current;
	}
	
	public static void main(String[] args) {

		SortedList theSortedList = new SortedList();
		theSortedList.insert(20); // insert 2 items
		theSortedList.insert(40);

		theSortedList.displayList(); // display list

		theSortedList.insert(10); // insert 3 more items
		theSortedList.insert(30);
		theSortedList.insert(50);

		theSortedList.displayList(); // display list

		theSortedList.remove(); // remove an item

		theSortedList.displayList(); // display list

	}
	
}
