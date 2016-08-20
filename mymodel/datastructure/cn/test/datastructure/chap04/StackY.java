package cn.test.datastructure.chap04;

public class StackY {
	
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public StackY(int s){
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}
	
	public void push(char i){
		stackArray[++top]=i;
	}
	
	public char pop(){
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
	
}
