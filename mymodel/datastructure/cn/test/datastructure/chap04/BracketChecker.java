package cn.test.datastructure.chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 检测括号是否匹配
 * @author shuang
 *
 */
public class BracketChecker {
	
	private String input;
	
	public BracketChecker(String in){
		this.input = in;
	}
	
	public void check(){
		int stackSize = input.length();
		StackY stack = new StackY(stackSize);
		
		for(int j=0;j<input.length();j++){
			char ch = input.charAt(j);
			switch (ch) {
			case '{':
			case '[':
			case '(':
				stack.push(ch);
				break;
			
			case '}':
			case ']':
			case ')':
				if(!stack.isEmpty()){
					char chx = stack.pop();
					if( (ch =='}'&& chx != '{') 
							|| (ch ==']'&& chx != '[') 
							|| (ch ==')'&& chx != '(') )
						System.out.println("Error: "+ch+" at "+j);
				}else
					System.out.println("Error: "+ch+" at "+j);
				break;
				
			default:
				break;
			}
		}
		if(!stack.isEmpty())
			System.out.println("Error: missing right delimiter");
	}
	
	public static void main(String[] args) throws IOException {
		String input;
		while(true){
			System.out.println("Enter a String containing delimiter: ");
			System.out.flush();
			input = getString();
			if(input.equals("")){
				break;
			}
			BracketChecker check = new BracketChecker(input);
			check.check();
		}
	}

	private static String getString() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		return br.readLine();
	}
}
