package cn.test.datastructure.chap05.demo05;

/**
 * 双端链表
 * @author shuang
 *
 */
public class DoubleLinkedList {

	private Link first;
	private Link last;

	public DoubleLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}
	/**
	 * 前端插入
	 * @param dd
	 */
	public void insertFirst(long dd) {
		Link newLink = new Link(dd);
		if (isEmpty())
			last = newLink;
		else
			first.previos = newLink;

		newLink.next = first;
		first = newLink;
	}
	
	/**
	 * 后端插入
	 * @param dd
	 */
	public void insertLast(long dd) {

	}
	
	/**
	 * 前端删除
	 * @return
	 */
	public Link deleteFirst() {
		
		return null;
	}
	
	/**
	 * 后端删除
	 * @return
	 */
	public Link deleteLast() {
		return null;
	}
	
	public boolean insertAfter(long key,long dd){
		return false;
	}
	
	/**
	 * 删除指定元素
	 * @param key
	 * @return
	 */
	public Link deleteKey(long key){
		return null;
	}
	
	/**
	 * 从前向后遍历元素
	 */
	public void displayForward(){
		
	}
	
	/**
	 * 从后向前遍历原始
	 */
	public void displayBackward(){
		
	}

}
