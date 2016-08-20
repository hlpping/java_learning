package cn.test.datastructure.chap05.demo04;

import cn.test.datastructure.chap05.demo02.Link;

public class SortedList {

	private Link first;

	public SortedList() {
		first = null;
	}

	public SortedList(Link[] linkArr) {
		first = null;
		for (int j = 0; j < linkArr.length; j++) {
			insert(linkArr[j]);
		}
	}

	public boolean isEmpty() {
		return first == null;
	}

	public Link remove() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	public void displayList() {
		System.out.println("List(First-->last):");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}

	public void insert(Link k) {
		Link previous = null;
		Link current = first;

		while (current != null && k.dData > current.dData) {
			previous = current;
			current = current.next;
		}
		if (previous == null)
			first = k;
		else
			previous.next = k;
		k.next = current;
	}

	public static void main(String[] args) {

		int size = 10;
		Link[] linkArray = new Link[size];

		for (int j = 0; j < size; j++) {
			int n = (int) (java.lang.Math.random() * 99);
			Link newLink = new Link(n); // make link
			linkArray[j] = newLink; // put in array
		}

		System.out.print("Unsorted array: ");
		for (int j = 0; j < size; j++)
			System.out.print(linkArray[j].dData + " ");
		System.out.println("");

		SortedList theSortedList = new SortedList(linkArray);

		for (int j = 0; j < size; j++)
			linkArray[j] = theSortedList.remove();

		System.out.print("Sorted Array:   ");
		for (int j = 0; j < size; j++)
			System.out.print(linkArray[j].dData + " ");
		System.out.println("");

	}

}
