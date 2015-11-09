package base.day02;

import org.junit.Test;

public class Test1 {
	/*
	这个类是今天第一个例子
	这里写了Java的基本语法的使用
	例如: 变量, 标识符, 语言格式
	多行注释不会被生成文档
	*/

	// 这是单行注释

	/*
	多
	行
	注
	释
	*/

	/**
	文
	档
	注
	释
	*/
	@Test
	public void syntax(){
		int x=90;
		int X=55;
		
		System.out.println(x);
		System.out.println(X);
		
		while(x>0){
			System.out.print(x%2+" ");
			x=x/2;
		}
		System.out.println();
		System.out.println(x);
	}
	@Test
	public void decimalToHex(){
		int x=198;
		StringBuffer sb=new StringBuffer();
		while(x>0){
			int y =x & 0xf;
			if(y<10){
				sb.append(y);
			}else{
				sb.append(y-10+'A');
			}
			x=x>>4;
			System.out.println(sb.reverse());
		}
	}
}
