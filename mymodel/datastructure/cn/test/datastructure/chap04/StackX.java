package cn.test.datastructure.chap04;

public class StackX {
	
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public StackX(int s){
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	
	public void push(long i){
		stackArray[++top]=i;
	}
	
	public long pop(){
		return stackArray[top--];
	}
	
	public long peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull(){
		return top==maxSize-1;
	}
	
	public static void main(String[] args) {
		/*
		int i=10;
		System.out.println(i++);  	//10
		System.out.println(i);		//11
		System.out.println(++i);	//12
		System.out.println(i);		//12
		System.out.println(i--);	//12
		System.out.println(i);		//11
		System.out.println(--i);	//10
		System.out.println(i);		//10
		*/
		
		 StackX theStack = new StackX(10);  // make new stack
	      theStack.push(20);               // push items onto stack
	      theStack.push(40);
	      theStack.push(60);
	      theStack.push(80);

	      while( !theStack.isEmpty() )     // until it's empty,
	         {                             // delete item from stack
	         long value = theStack.pop();
	         System.out.print(value);      // display it
	         System.out.print(" ");
	         }  
	      System.out.println("");
		
	}
}
