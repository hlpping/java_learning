package basestrong.variableparameters;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/** 
 * @author 双
 * @vision Jun 14, 2011
 * 主要是 for循环加强 
 * 		可变参数
 */
public class ForTest {
	ForTest(String ...s) {		
	}
	ForTest(Integer ...n){		
	}
	public static void main(String[] args) {
		//可变参数
		new ForTest(1,2,3,4);
		new ForTest("qq","ss","cc","bb");		
//		datedemo();
		test4();
	}
	private static void test4() {
		// 关于MessageFormat可以查阅API,主要功能是做格式化
		Calendar c =Calendar.getInstance();
		c.add(Calendar.DATE , 3);
		Object[] o =new Object []{3,c.getTime(),"北京"};
		String str =MessageFormat.format("我将在{0,number}天后,"+
										"即{1,date,full}时,"+
										"到达:{2}", o);
		System.out.println(str);		
		String str1 =MessageFormat.format("我将在{0,number}天后,"+
				"即{1,date,full}时,"+
				"到达:{2}", 3,c.getTime(),"北京");
		System.out.println(str1);
	}
	//可变参数的应用
	private static void datedemo() {
		Date d =new Date();
		SimpleDateFormat s=new SimpleDateFormat();
		System.out.println(s.format(d));
		
		String ss=MessageFormat.format("hello{0} ,bb{1}", " sdfsf");
		System.out.println(ss);
		String ss2=MessageFormat.format("hello{0},nice to see you{1}", " 李林"," 韩梅梅");
		System.out.println(ss2);
		
	}
	// for循环 尽量使用基本数据类型 Integer Character等
	public void test2(){
		Integer[] num=new Integer[]{1,2,3,4,5};
		List<Integer> list=Arrays.asList(num);
		for(Integer n: list)
			System.out.println(n);
	}
	
	public void test1(){
		String[] str=new String[]{"aa","bb","cc","dd","ee"};
		List<String> list=Arrays.asList(str);
		for(String s: list)
			System.out.println(s);
	}
}
