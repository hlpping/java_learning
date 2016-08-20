package cn.test.datastructure.chap02;

public class HighArray {

	private long[] arr;
	private int n;

	public HighArray(int size) {
		arr = new long[size];
		n = 0;
	}

	public boolean find(long key) {
		int j;

		for (j = 0; j < n; j++) {
			if (arr[j] == key) {
				break;
			}
		}
		if (j == n) {
			return false;
		} else
			return true;
	}

	public void insert(long value) {
		arr[n] = value;
		n++;
	}

	public boolean delete(long value) {
		int j = 0;
		for (j = 0; j < n; j++) {
			if (arr[j] == value) {
				break;
			}
		}
		if (j == n) {
			return false;
		} else {
			for (int k = j; k < n; k++) {
				arr[k] = arr[k + 1];
			}
			n--;
			return true;
		}
	}

	public void display() {
		for (int j = 0; j < n; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int maxSize = 100;
		HighArray arr = new HighArray(maxSize);
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		
		arr.display();
		int searchkey = 35;
		if(arr.find(searchkey)){
			System.out.println("Found "+searchkey);
		}else{
			System.out.println("Can't find "+searchkey);
		}
		
		arr.delete(00);
		arr.delete(55);
		arr.delete(99);
		
		arr.display();

	}
}
