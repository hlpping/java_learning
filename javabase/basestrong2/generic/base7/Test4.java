package basestrong2.generic.base7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//通配符
public class Test4 {

	public static void main(String[] args) {
		List<Integer> list =new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		print1(list);
		System.out.println();
		print2(list);
		System.out.println("\n----------------");
		
		
		List<String> list2 =new ArrayList<String>();
		list2.add("1");
		list2.add("2");
		list2.add("3");
		list2.add("4");
		
//		print1(list2);		//错误
		print2(list2);		
		System.out.println("\n----------------");
	}
	//非通配符方法
	public static void print1(Collection<Integer> c) {
		for(Integer i:c){
			System.out.print(i+" ");
		}
	}
	//通配符方法
	public static void print2(Collection<?> c) {
		//不能调用与类型有关的方法,可以调用与类型无关的方法
		c.size();
		for(Object i:c){
			System.out.print(i+" ");
		}
	}
}
