package cn.test.datastructure.chap04;

public class Queue {
	
	private int maxSize;			//最大
	private long[] queueArray;		//存放数据的数组
	private int front;				//队列的头
	private int rear;				//队列的尾
	private int nItems;			//队列的数量

	public Queue(int s) {
		maxSize = s;
		queueArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	/**
	 * insert 队尾+1,对列数量+1,从队列后面加入新元素
	 * 队列满了,不能再加新元素
	 * @param j
	 */
	public void insert(long j) {
		if(isFull()){
			System.out.println("队列已满");
			return;
		}
		if (rear == maxSize - 1)
			rear = -1;
		queueArray[++rear] = j;
		nItems++;
	}
	
	/**
	 * remove 对头+1,队列数量-1,从队列前删除新元素
	 * 队列空了不能再加新元素
	 * @return
	 */
	public long remove() {
		if(isEmpty()){
			System.out.println("队列已空");
			return -100;
		}
		long temp = queueArray[front++];
		if (front == maxSize) {
			front = 0;
		}
		nItems--;
		return temp;
	}

	public long peekFront() {
		return queueArray[front];
	}

	public boolean isEmpty() {
		return nItems == 0;
	}
	
	public boolean isFull() {
		return nItems == maxSize;
	}

	public int size() {
		return nItems;
	}
	
	public void display(){
		for(int i=0;i<queueArray.length;i++){
			System.out.print(queueArray[i]);
			System.out.print(" ");
		}
		System.out.print("\t\t maxSize " + maxSize +" nIttems "+nItems+" front "+front+" rear "+rear);
		System.out.println();
	}

	public static void main(String[] args) {

		Queue queue = new Queue(5); // queue holds 5 items

		queue.insert(10); 
		queue.display();
		queue.insert(20);
		queue.display();
		queue.insert(30);
		queue.display();
		queue.insert(40);
		queue.display();
		
		queue.remove(); // remove 3 items
		queue.display();
		queue.remove(); // (10, 20, 30)
		queue.display();
		queue.remove();
		queue.display();

		queue.insert(50); // insert 4 more items
		queue.display();
		queue.insert(60); // (wraps around)
		queue.display();
		queue.insert(70);
		queue.display();
		queue.insert(80);
		queue.display();

		System.out.println("------------");
		// remove and display
		while (!queue.isEmpty()) { // all items
			long n = queue.remove(); // (40, 50, 60, 70, 80)
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println("");
	}
}
