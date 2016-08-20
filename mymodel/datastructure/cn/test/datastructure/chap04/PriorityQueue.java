package cn.test.datastructure.chap04;

public class PriorityQueue {

	private int maxSize; 			// 最大
	private long[] queueArray; 		// 存放数据的数组
	private int nItems; 			// 队列的数量

	public PriorityQueue(int s) {
		maxSize = s;
		queueArray = new long[maxSize];
		nItems = 0;
	}

	public void insert(long item) {
		int j;
		//如果队列为空,则直接插入
		//否则,判断每个元素与新元素的关系,若比新元素大,则将旧元素右移
		if (nItems == 0)
			queueArray[nItems++] = item;
		else {
			for (j = nItems - 1; j >= 0; j--) {
				if (item > queueArray[j])
					queueArray[j + 1] = queueArray[j];
				else
					break;
			}
			queueArray[j + 1] = item;
			nItems++;
		}
	}
	
	public long remove(){
		return queueArray[--nItems];
	}

	public long peekMin(){
		return queueArray[nItems-1];
	}
	
	public boolean isEmpty(){
		return nItems == 0;
	}
	
	public boolean isFull(){
		return nItems == maxSize;
	}
	
	public void display(){
		for(int i=0;i<queueArray.length;i++){
			System.out.print(queueArray[i]);
			System.out.print(" ");
		}
		System.out.print("\t\t nIttems "+nItems);
		System.out.println();
	}
	
	public static void main(String[] args) {
		PriorityQueue thePQ = new PriorityQueue(5);
		
		thePQ.insert(30);
		thePQ.display();
		thePQ.insert(50);
		thePQ.display();
		thePQ.insert(10);
		thePQ.display();
		thePQ.insert(40);
		thePQ.display();
		thePQ.insert(20);
		thePQ.display();

		System.out.println("----------");
		while (!thePQ.isEmpty()) {
			long item = thePQ.remove();
			System.out.print(item + " "); 
			// 10, 20, 30, 40, 50
		} 
		System.out.println("");
	}
}
