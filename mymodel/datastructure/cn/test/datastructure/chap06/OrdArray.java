package cn.test.datastructure.chap06;

public class OrdArray {
	
	private long[] a;
	private int nElemes;
	
	public OrdArray(int max){
		a = new long[max];
		nElemes =0;
	}
	
	public int size(){
		return nElemes;
	}
	
	public int find(long searchKey){
		return recFind(searchKey,0,nElemes-1);
	}

	private int recFind(long searchKey, int lower, int upper) {
		int curIn;
		curIn = (lower+upper)/2;
		if(a[curIn] == searchKey)
			return curIn;
		else if(lower>upper)
			return nElemes;
		else{
			if(a[curIn]<searchKey)	//上半部分
				return recFind(searchKey, curIn+1, upper );
			else	//下半部分
				return recFind(searchKey, lower, curIn-1 );
		}
	}
	
	public void insert(long value){
		int j;
		for(j=0;j<nElemes;j++)
			if(a[j]>value)
				break;
		for(int k=nElemes;k>j;k--)
			a[k]=a[k-1];
		a[j] = value;
		nElemes++;
	}
	
	public void display(){
		for(int j=0;j<nElemes;j++)
			System.out.print(a[j]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int maxSize = 100;             // array size
		OrdArray arr;                  // reference to array
	      arr = new OrdArray(maxSize);   // create the array

	      arr.insert(72);                // insert items
	      arr.insert(90);
	      arr.insert(45);
	      arr.insert(126);
	      arr.insert(54);
	      arr.insert(99);
	      arr.insert(144);
	      arr.insert(27);
	      arr.insert(135);
	      arr.insert(81);
	      arr.insert(18);
	      arr.insert(108);
	      arr.insert(9);
	      arr.insert(117);
	      arr.insert(63);
	      arr.insert(36);

	      arr.display();                 // display array

	      int searchKey = 27;            // search for item
	      if( arr.find(searchKey) != arr.size() )
	         System.out.println("Found " + searchKey);
	      else
	         System.out.println("Can't find " + searchKey);
	}
	
}
