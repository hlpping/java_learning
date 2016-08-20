package cn.test.datastructure.chap05.demo06;

public class ListIterator {
	
	private Link current;
	private Link previos;
	private LinkList ourList;
	
	public ListIterator(LinkList list){
		ourList = list;
		reset();
	}

	public void reset() {
		current = ourList.getFirst();
		previos = null;
	}
	
	public boolean atEnd(){
		return current.next == null;
	}
	
	public void nextLink(){
		previos = current;
		current = current.next;
	}
	
	public Link getCurrent(){
		return current;
	}
	
	public void insertAfter(long dd){
		Link newLink = new Link(dd);
		
		if(ourList.isEmpty()){
			ourList.setFirst(newLink);
			current = newLink;
		}else{
			newLink.next = current.next;
			current.next = newLink;
			nextLink();
		}
	}
	
	public void insertBefore(long dd){
		Link newLink = new Link(dd);
		
		if(previos == null){
			newLink.next = ourList.getFirst();
			ourList.setFirst(newLink);
			reset();
		}else{
			newLink.next = previos.next;
			previos.next = newLink;
			current = newLink;
		}
	}
	
	public long deleteCurrent(){
		long value = current.dData;
		if(previos == null){
			ourList.setFirst(current.next);
			reset();
		}else{
			previos.next = current.next;
			if(atEnd())
				reset();
			else
				current = current.next;
		}
		return value;
	}
}
