package cn.test.datastructure.chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Reverser {

	private String input;
	private String output;

	public Reverser(String in) {
		this.input = in;
	}
	
	public String doRev(){
		int stackSize = input.length();
		StackY stack = new StackY(stackSize);
		
		for(int j=0;j<input.length();j++){
			char ch = input.charAt(j);
			stack.push(ch);
		}
		
		output = "";
		
		while(!stack.isEmpty()){
			char ch = stack.pop();
			output = output+ch;
		}
		return output;
	}
	
	public static void main(String[] args) throws IOException {
		
		String input,output;
		while(true){
			System.out.println("Enter a String: ");
			System.out.flush();
			input = getString();
			if(input.equals("")){
				break;
			}
			Reverser reverser = new Reverser(input);
			output = reverser.doRev();
			System.out.println("Ourput : "+output);
		}
	}

	private static String getString() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		return br.readLine();
	}
}
