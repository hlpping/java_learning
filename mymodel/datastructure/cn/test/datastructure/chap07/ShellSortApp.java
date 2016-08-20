package cn.test.datastructure.chap07;

public class ShellSortApp {
	
	public static void main(String[] args) {
		int maxSize =10;
		ArraySh arr = new ArraySh(maxSize);
		
		for(int j=0;j<maxSize;j++){
			long n = (long) (Math.random()*99);
			arr.insert(n);
		}

		arr.display();
		arr.shellSort();
		arr.display();
	}
}

class ArraySh {
	private long[] theArray;
	private int nElemt;

	public ArraySh(int max) {
		theArray = new long[max];
		nElemt = 0;
	}

	public void insert(long value) {
		theArray[nElemt] = value;
		nElemt++;
	}

	public void display() {
		System.out.print("A= ");
		for (int j = 0; j < nElemt; j++)
			System.out.print(theArray[j] + " ");
		System.out.println();
	}

	public void shellSort() {
		int inner, outer;
		long temp;

		int h = 1;
		while(h<=nElemt/3)
			h = h*3+1;
		
		while (h > 0) {
			System.out.println("h: "+h);
			for (outer = h; outer < nElemt; outer++) {
				System.out.println(" "+outer+" "+theArray[outer]);
				temp = theArray[outer];
				inner = outer;
				while(inner >h-1 && theArray[inner-h]>=temp){
					theArray[inner] = theArray[inner-h];
					inner -= h;
				}
				theArray[inner] = temp;
			}
			h = (h-1)/3;
		}
	}

}