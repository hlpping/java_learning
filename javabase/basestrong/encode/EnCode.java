package basestrong.encode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;
/**
 *  加密算法
 */

public class EnCode {
	public static void main(String[] args) throws Exception {
//		test1();
		
		//~ & | ^ --1010101001
		//& = 两个都为1才为1
		//| = 只要一个为1就是1
		//~ = 按位取反 - 1-0,0-1
		//^ = 不同为1，相同为0
		
		int a = -9;
		int b = -3;
		int c = a^b;
		System.err.println(Integer.toBinaryString(a));
		System.err.println(Integer.toBinaryString(b));
		System.err.println(Integer.toBinaryString(c)+","+c);
		
	}
	/*
	public void aa(){
		Md5PasswordEncoder md5 = new Md5PasswordEncoder(); 此类不可用
		String s = "Hesfadfaafsfdsdlo";
		int a = s.hashCode();
		a = a&30;
		System.err.println(a);	
		
		String str = md5.encodePassword(s,""+a);
		System.err.println(str);
	}
	*/

	private static void test1() throws NoSuchAlgorithmException {
		String str ="abcd";
		MessageDigest m=MessageDigest.getInstance("SHA"); //MD5
		byte[] b= m.digest(str.getBytes()); 
		String s =new String(b);
		System.out.println(s);
		
		BASE64Encoder b64=new BASE64Encoder();
		String ss = b64.encode(b);
		System.out.println(ss);
	}

}
