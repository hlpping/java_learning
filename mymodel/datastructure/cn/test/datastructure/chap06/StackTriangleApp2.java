package cn.test.datastructure.chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackTriangleApp2 {
	
	static int theNumber;
	static int theAnswer;
	static StackX theStack;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter a number: ");
		theNumber = getInt();
		stackTriangle();
		System.out.println(""+theAnswer);
	}

	private static void stackTriangle() {
		
		theStack = new StackX(1000);
		theAnswer = 0;
		
		//将100到1放入到栈中
		while(theNumber >0){
			theStack.push(theNumber);
			--theNumber;
		}
		//从栈中取出所有数字做加法
		while(!theStack.isEmpty()){
			int newN = theStack.pop();
			theAnswer += newN;
		}
		
	}
	
	private static int getInt() throws NumberFormatException, IOException {
		return Integer.parseInt(getString());
	}
	
	private static String getString() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		return br.readLine();
	}

}
class StackX{
	private int maxSize;
	private int[] stackArray;
	private int top;
	
	public StackX(int s){
		maxSize = s;
		stackArray = new int[maxSize];
		top =  -1;
	}
	
	public void push(int p){
		stackArray[++top] = p;
	}
	
	public int pop(){
		return stackArray[top--];
	}
	
	public int peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
}