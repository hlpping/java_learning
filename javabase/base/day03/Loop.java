package base.day03;

import org.junit.Test;

public class Loop {
	@Test
	public void test1(){
		int x=0;
		while(x++<10){
			if(x==5)
				break;			// 结束循环
			System.out.println(x);
		}
		System.out.println("OVER");		
	}
	@Test
	public void test2(){
		int x = 0;
		while(x++ < 10){	
			if(x == 5){
				continue;	// 跳过一次循环, 循环内代码不再执行, 直接进入下一次判断
			}
			System.out.println(x);	
		}	
		System.out.println("程序结束");
	}
	@Test
	public void test3(){
		int x = 0;
		while(x++ < 10){	
			if(x == 5){
				return;		// 跳过一次循环
			}
			System.out.println(x);	
		}	
		System.out.println("程序结束");
	}
	@Test
	public void test4(){
		int x=0;
		do{
			System.out.println(x);
		}while(x++ <10);
		
	}
	@Test
	public void test5(){
		int x = 0;
		while(x < 10){
			System.out.println(x);	
			x++;
		}		
	}
	@Test
	public void test6(){
		for(int x = 0; x < 10; x++){	
			System.out.println(x);
		}
	}
	
}
