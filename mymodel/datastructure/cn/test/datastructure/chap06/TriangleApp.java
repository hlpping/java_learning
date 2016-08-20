package cn.test.datastructure.chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleApp {
	
	static int number;
	
	public static void main(String[] args) throws IOException {
		System.out.println("enter a number:");
		number = getInt();
		int answer = triangle(number);
		System.out.println("Triangle = "+answer);
	}

	private static int triangle(int n) {
		System.out.println("enter : "+n);
		int temp;
		if(n == 1)
			temp = 1;
		else
			temp = (n+triangle(n-1));
		
		System.out.println("return : " + temp);
		return temp;
	}

	private static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}

	private static String getString() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		return br.readLine();
	}
}
