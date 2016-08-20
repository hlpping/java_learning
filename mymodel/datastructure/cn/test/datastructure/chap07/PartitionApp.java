package cn.test.datastructure.chap07;

public class PartitionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxSize = 16;             // array size
	      ArrayPar arr;                 // reference to array
	      arr = new ArrayPar(maxSize);  // create the array

	      for(int j=0; j<maxSize; j++)  // fill array with
	         {                          // random numbers
	         long n = (int)(java.lang.Math.random()*199);
	         arr.insert(n);
	         }
	      arr.display();                // display unsorted array

	      long pivot = 99;              // pivot value
	      System.out.print("Pivot is " + pivot);
	      int size = arr.size();
	                                    // partition array
	      int partDex = arr.partitionIt(0, size-1, pivot);

	      System.out.println(", Partition is at index " + partDex);
	      arr.display();                // display partitioned array
	}

}

class ArrayPar {
	private long[] thearray;
	private int nelems;

	public ArrayPar(int max) {
		thearray = new long[max];
		nelems = 0;
	}

	public void insert(long value) {
		thearray[nelems] = value;
		nelems++;
	}

	public int size() {
		return nelems;
	}

	public void display() {
		System.out.print("A= ");
		for (int j = 0; j < nelems; j++)
			System.out.print(thearray[j] + " ");
		System.out.println();
	}

	public int partitionIt(int left, int right, long pivot) {
		System.out.println();
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		while (true) {
//			System.out.println(".."+leftPtr+","+rightPtr);
			while (leftPtr < right && thearray[++leftPtr] < pivot)
				;
			while (rightPtr > left && thearray[--rightPtr] > pivot)
				;
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
			
			display();

		}
		return leftPtr;

	}

	public void swap(int dex1, int dex2) {
//		System.out.println(">>"+dex1+","+dex2);
		long temp;
		temp = thearray[dex1];
		thearray[dex1] = thearray[dex2];
		thearray[dex2] = temp;
	}

}