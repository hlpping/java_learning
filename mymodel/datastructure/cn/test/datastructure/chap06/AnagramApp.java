package cn.test.datastructure.chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramApp {

	static int size;						//输入字符的长度
	static int count;						//序号
	static char[] arrchar = new char[100];	//存储输入字符的字符数组
	
	/**
	 * 读取键盘输入
	 * @return
	 * @throws IOException
	 */
	private static String getString() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		return br.readLine();
	}
	
	/**
	 * 变位字
	 * 递归方法实现
	 * input = 1 return 
	 * input = 2 
	 * @param newsize
	 */
	private static void doAnagram(int newsize) {
		if (newsize == 1)
			return;
		for (int j = 0; j < newsize; j++) {
			doAnagram(newsize - 1);
			if (newsize == 2)
				dispalyWord();
			rotate(newsize);
		}
	}
	
	/**
	 * 旋转字符
	 * @param newsize
	 */
	private static void rotate(int newsize) {
		int j;
		int position = size - newsize;
		char temp = arrchar[position];

		for (j = position + 1; j < size; j++)
			arrchar[j - 1] = arrchar[j];
		arrchar[j - 1] = temp;
	}
	
	/**
	 * 处理输出样式
	 */
	private static void dispalyWord() {
		if (count < 99)
			System.out.print(" ");
		if (count < 9)
			System.out.print(" ");
		// 输出序号
		System.out.print(++count + " ");
		// 输出
		for (int j = 0; j < size; j++)
			System.out.print(arrchar[j]);
		System.out.print(" ");
		System.out.flush();

		// 六个换行
		if (count % 6 == 0)
			System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("enter a word: ");
		String input = getString();

		size = input.length();
		count = 0;
		for (int j = 0; j < size; j++)
			arrchar[j] = input.charAt(j);
		doAnagram(size);
	}
	
}
