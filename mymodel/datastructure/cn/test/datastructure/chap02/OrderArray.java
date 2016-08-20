package cn.test.datastructure.chap02;

public class OrderArray {

	private long[] a;
	private int nElems;

	public OrderArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	public int size() {
		return nElems;
	}

	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println("");
	}

	public int find(long searchKey) {
		int lowerBound = 0;

		int upperBound = nElems - 1;

		int curIn;

		while (true) {
			curIn = (lowerBound + upperBound) / 2;

			if (a[curIn] == searchKey) {
				return curIn;
			} else if (lowerBound > upperBound) {
				return nElems;
			} else {
				if (a[curIn] < searchKey) {
					lowerBound = curIn + 1;
				} else {
					upperBound = curIn - 1;
				}
			}
		}
	}
	
	public void insert(long value){
		int j;
		j = find(value);		//二分法查找
		/*
		for( j=0;j<nElems;j++){	//线性查找
			if(a[j]>value)
				break;
		}
		*/
		for(int k = nElems ;k>j ; k--){
			a[k] =a[k-1];
		}
		a[j] = value;
		nElems++;
	}
	
	public boolean delete(long value){
		int j = find(value);
		if(j==nElems)
			return false;
		else{
			for(int k=j; k<nElems;k++)
				a[k] = a[k+1];
			nElems--;
			return true;
		}
	}
	
	public static void main(String[] args) {
		
		int maxSize = 100;
		OrderArray arr = new OrderArray(maxSize);
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
		int searchkey = 55;
		if(arr.find(searchkey)!= arr.size()){
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
