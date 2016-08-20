package cn.test.datastructure.chap13.demo02;

public class Queue {
	
	private final int SIZE =20;		//最大
	private int[] queueArray;		//存放数据的数组
	private int front;				//队列的头
	private int rear;				//队列的尾
	
	public Queue() {
		queueArray = new int[SIZE];
		front = 0;
		rear = -1;
	}
	
	public void insert(int j){
		if(rear ==SIZE-1)
			rear =-1;
		queueArray[++rear] = j;
	}
	
	public int remove(){
		int temp = queueArray[front++];
		if(front == SIZE)
			front =0;
		return temp;
	}
	
	public boolean isEmpty() {
		return rear+1 == front || front+SIZE-1 == rear;
	}
	
}
