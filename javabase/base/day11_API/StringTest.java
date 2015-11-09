package base.day11_API;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class StringTest {	
	@Test
	public void test1(){
			//1
		System.out.println(getExtname("Person.java"));
		System.out.println(getExtname("Person.java.txt"));
	}
	@Test
	public void test2(){
		//2
		int[] arr = indexOf("xxxabcdefabcdefxxx", "abc");
		System.out.println(Arrays.toString(arr));
		arr = indexOf("aabbccddaaeeaa", "aa");
		System.out.println(Arrays.toString(arr));
	}
	@Test
	public void test3(){
		//3
		char c = findMostChar("aabbccddaabbaa");
		System.out.println(c);
		c = findMostChar("aabxxxxxbccxxxxddaaxxxxbbaa");
		System.out.println(c);
		c = findMostChar("aabbcc");
		System.out.println(c);
	}
	@Test
	public void test4() throws IOException{
		//4
		System.out.println("请输入:");
		while (true) {
			String s = readLine();
			System.out.println(s);
			if (s.equals("bye"))
				break;
		}
	}
	@Test
	public void test5GB2312(){	
		printGB2312("abc中文", 3);
		printGB2312("abc中文", 4);
		printGB2312("abc中文", 5);
		printGB2312("abc中文", 6);
		printGB2312("abc中文", 7);
		System.out.println();
		
		printGBK("abc中驫", 4);
		printGBK("abc中驫", 6);
		printGBK("abc中驫", 7);		
	}
	@Test
	public void test6(){	
		//6
		System.out.println(findMaxSubstring("abcdef", "xxxxcdexxx"));
		System.out.println(findMaxSubstring("xxxxxxxaaaxxx", "ooooaaaooooo"));
		System.out.println(findMaxSubstring("xxxxxxxaaaxxx", "oooobbbooooo"));
	}
	
	/*
	 * 1.设计一个方法, 获取一个已知文件的扩展名. 例如: Person.java的扩展名为java, Person.java.txt的扩展名为txt.
	 * 		思路:
	 * 			找到文件名中的最后一个"."所在的索引
	 * 			从这个位置+1开始截取, 到字符串末尾, 就是扩展名
	 */
	public static String getExtname(String name) {
		int index=name.lastIndexOf(".");
		String ext =name.substring(index+1);
		return ext;
	}
	
	/*
	 * 2.设计一个方法, 查找一个字符串中子字符串出现的所有位置. 多个位置保存到一个int数组中返回.
	 * 		"xxxabcdefabcdefxxx", "abc", 第一次出现是3, 第二次是9. 那么返回一个数组 {3,9}
	 * 		思路:
	 * 			在循环中查找abc所在位置, 找到一次之后从上一次所在位置继续查找
	 * 			直到找不到时, 结束循环
	 */
	public static int[] indexOf(String src, String sub) {
		int start =0;
		StringBuffer sb =new StringBuffer();
		while(true){
			int index =src.indexOf(sub,start);
			if(index==-1)
				break;
			start=index+sub.length();
			sb.append(index+",");				
		}
		sb.deleteCharAt(sb.length()-1);
		String result=sb.toString();
		String[] resultArr=result.split(",");
		
		int[] arr =new int[resultArr.length];
		for(int i=0;i<arr.length;i++){
			arr[i]=Integer.parseInt(resultArr[i]);
		}
		return arr;
	}
		
	/*
	 * 3.查找一个字符串中出现最多的字符.
	 * 		"aabbccddaabbaa" 'a'
	 * 		思路:
	 * 			定义一个变量mostTimes, 用来记住出现最多的字符的次数, 初始值为0.
	 * 			先从字符串中获取第一个字符, 统计这个字符在字符串中出现了多少次.
	 * 			用这个次数和mostTimes比较, 如果比mostTimes大, 那么让mostTimes记住当前这个字符的次数. 并且用一个变量记住当前的字符.
	 * 			统计完一个字符之后, 将这个字符从字符串中删除. 
	 * 			进入下一次循环, 再次统计第一个字符, 如果这个字符比mostTimes次数大, 那么记住这一个
	 * 			循环结束之后mostTimes就会记住最多的次数
	 */
	public static char findMostChar(String src) {
		int mostTimes=0;
		char mostChar=src.charAt(0);
		while(true){
			int currentTimes=0;
			char currentChar=src.charAt(0);
			for(int i=0; i<src.length();i++){
				if(currentChar==src.charAt(i))
					currentTimes++;
			}
			if(currentTimes > mostTimes){
				mostTimes=currentTimes;
				mostChar=currentChar;
			}
			// 将统计过的字符删除
			src=src.replace(String.valueOf(currentChar), "");
			if(src.length()==0){
				System.out.println("最多的字符是" + mostChar + ", 次数是" + mostTimes);
				return mostChar;				
			}
		}		
	}	
	
	// 3.2 这个方法是为了回答同学的问题, 解决多个字符出现次数相同的问题.
	public static String findMostChar1(String s) {
		
		return  null;
	}

	/*
	 * 4.设计方法,使用System.in.read()读取一行, \r\n问题, 中文问题.
	 * 		思路:
	 * 			在循环中使用System.in.read()读取
	 * 			将读取到的结果存入StringBuilder
	 * 			直到读到回车换行, 循环结束
	 * 			将StringBuilder中保存的内容返回
	 */
	public static String readLine() throws IOException {
		
		StringBuffer sb =new StringBuffer();
		while(true){
			byte b=(byte) System.in.read();
			if(b=='\r')// 判断这个字节, 如果是\r, 代表遇到了行的结尾
				break;
			if(b=='\n')
				continue;
			if(b<0){
				byte b1=(byte) System.in.read();
				byte[] arr=new byte[]{b,b1};
				String s =new String(arr);
				sb.append(s);
			}else
				sb.append((char)b);			
		}
		return sb.toString();		
	}
	
	/*
	 * 5.已知一个字符串. 设计一个方法, 可以从这个字符串中打印n个字节. 但不能打印出半个中文.
	 * 		短信长度是140字节, 如果超出140个, 会分为两条.
	 * 		如果第140字节是中文的前半, 141字节是中文的后半, 那么第一条短信只能显示139字节
	 * 		"abc中文" 4, abc
	 * 		"abc中文" 5, abc中
	 * 		"abc中文" 6, abc中
	 */
	public static void printGB2312(String str, int count) { // GB2312 中文占2个负数
		byte[] arr =str.getBytes();
		int times=0;
		for(int i=0;i<count;i++){
			if(arr[i]<0)
				times++;
		}
		if(times%2==1)
			count--;
		String result=new String(arr,0,count);
		System.out.println(result);
	}	
	public static void printGBKSimple(String s, int count) {
		byte[] arr = s.getBytes();
		boolean isCnBegin = false;
		for (int i = 0; i < count; i++)
			isCnBegin = arr[i] < 0 && !isCnBegin;
		System.out.println(new String(arr, 0, count - (isCnBegin ? 1 : 0)));
	}

	public static void printGBK(String s, int count) {
		byte[] arr = s.getBytes();
		boolean isCnBegin = false; // 定义一个变量, 用来标识当前字节是否是中文的前半.

		for (int i = 0; i < count; i++) {
			if (arr[i] < 0 && !isCnBegin) { // 如果当前字节是负数, 并且前一个不是中文的前半, 当前的字节就是中文前半
				isCnBegin = true;
			} else {
				isCnBegin = false;
			}
		}

		if (isCnBegin)
			count--;

		String result = new String(arr, 0, count);
		System.out.println(result);
	}
	
	/*
	 * 6.查找两个字符串中最大子串.
	 * 		"abcdef"和"xxxxcdexxx"
	 * 		"xxxxxxxaaaxxx"和"ooooaaaooooo"
	 * 		"abcdef"的子串abcdef, abcde, bcdef, abcd .....
	 */
	public static String findMaxSubstring(String str, String str2) {
		String subString =null;
		for(int i=0;i<str.length();i++){
			for(int j=0;j<i+1;j++){
				subString=str.substring(j, str.length()-(i-j));
				if(str2.contains(subString))
				return subString;
			}
		}
		return null;
	}
}
