package cn.test.other.demo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListUtil {
	public static void main(String[] args) throws ParseException {
		List<String> keyList =new ArrayList<String>();	//关键字列表
		keyList.add("main_1_1");
		keyList.add("main_1_2");
		keyList.add("main_1_3");
		keyList.add("main_1_4");
		keyList.add("main_2_1");
		keyList.add("main_2_2");
		keyList.add("main_2_3");
		keyList.add("main_2_4");
		keyList.add("main_3_1");
		keyList.add("main_3_2");
		keyList.add("main_3_3");
		keyList.add("main_3_4");
		keyList.add("top_1_1 ");
		keyList.add("top_1_1 ");
		keyList.add("top_1_1 ");
		keyList.add("top_1_1 ");
		
//		List<String> keyList2=removeDuplicateWithOrder(keyList);
		keyList=removeDuplicateWithOrder(keyList);
		
		for(int i=0;i<keyList.size();i++){			
				System.out.println(keyList.get(i));
		}
	}

	@SuppressWarnings("unchecked")
	public static List removeDuplicateWithOrder(List list) {
		Set set = new HashSet(list.size());
		set.addAll(list);
		List newList = new ArrayList(set.size());
		newList.addAll(set);
		return newList;
	}

	@SuppressWarnings("unchecked")
	public static List removeDuplicateWithOrder2(List list) {
		Set set = new HashSet();
		List newList = new ArrayList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (set.add(element))
				newList.add(element);
		}
		return newList;
	}
}