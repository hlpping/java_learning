package cn.test.datastructure.chap06;

public class MergeApp2 {

	public static void main(String[] args) {
		
		int maxSize = 100;             // array size
	      DArray arr;                    // reference to array
	      arr = new DArray(maxSize);     // create the array

	      arr.insert(64);                // insert items
	      arr.insert(21);
	      arr.insert(33);
	      arr.insert(70);
	      arr.insert(12);
	      arr.insert(85);
	      arr.insert(44);
	      arr.insert(3);
	      arr.insert(99);
	      arr.insert(0);
	      arr.insert(108);
	      arr.insert(36);

	      arr.display();                 // display items

	      arr.mergeSort();               // merge sort the array

	      arr.display();                 // display items again
	}
}

class DArray{
	private long[] theArray;
	private int nElems;
	
	public DArray(int max){
		theArray = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		theArray[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(theArray[j] + " ");
		System.out.println();
	}
	
	public void mergeSort(){
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace,0,nElems-1);
	}

	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		// TODO Auto-generated method stub
		if(lowerBound == upperBound)
			return;
		else{
			int mid = (lowerBound+upperBound)/2;
			recMergeSort(workSpace, lowerBound, mid);
			recMergeSort(workSpace, mid+1, upperBound);
			merge(workSpace,lowerBound,mid+1,upperBound);
		}
	}

	private void merge(long[] workSpace, int lowerptr, int hightptr, int upperBound) {
		
		int j =0;
		int lowerBound = lowerptr;
		int mid = hightptr-1;
		int n= upperBound -lowerBound+1;
		
		while(lowerptr <= mid && hightptr <= upperBound)
			if(theArray[lowerptr] < theArray[hightptr])
				workSpace[j++] = theArray[lowerptr++];
			else
				workSpace[j++] = theArray[hightptr++];
		
		while(lowerptr <= mid)
			workSpace[j++] = theArray[lowerptr++];
		
		while(hightptr <= upperBound)
			workSpace[j++] = theArray[hightptr++];
		
		for(j=0;j<n;j++)
			theArray[lowerBound+j] = workSpace[j];
	}
	
}
