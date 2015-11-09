package basestrong2.generic.base1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
@SuppressWarnings("unchecked")
public class Test1 {
	
	@Test
	public void test1(){
		List list =new ArrayList();
		list.add("aa");
		String str =(String) list.get(0);
		System.out.println(str);
		Integer k =(Integer) list.get(0);
		System.out.println(k);
	}
	
	@Test
	public void test2(){		
		List<String> list =new ArrayList<String>();
		list.add("e");
//		Integer i=(Integer)list.get(0);
//		list.add(12);		
	}
	//使用迭代器迭代泛型集合的元素,增强for循环
	@Test
	public void test3(){	
		List<Integer> list =new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		Iterator<Integer> it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}		
	}
	//存取hashmap中的元素(重点)
	@Test
	public void test4(){
		Map<String, Integer> map =new HashMap<String, Integer>();
		map.put("key01", 1);
		map.put("key02", 2);
		map.put("key03", 3);
		map.put("key04", 4);
		//?
		Set<Map.Entry<String, Integer>> set=map.entrySet();
		for(Map.Entry<String, Integer> en:set){
			System.out.println(en.getKey()+"  "+en.getValue());
		}
	}
	
	
	@Test
	public void test5(){
//		List<String> list1 = new ArrayList<Object>();  //错
//		List<Object> list2 = new ArrayList<String>(); //错
		List<String> list3 = new ArrayList ();               //行
		List list4 = new ArrayList<String>();               //行
		/*
		 * 使用泛形时，泛形类型须为引用类型，不能是基本数据类型
		 * 两边的类型必须一致
		 * 两边只有一边用泛型(为了保持兼容性)
		 */		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
