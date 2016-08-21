package cn.test.demo02.beanutils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConstructorUtils;
import org.junit.Test;

public class App {
	
	/**
	 * static java.util.Map describe(java.lang.Object bean)
  	 * 返回一个Object中所有的可读属性，并将属性名/属性值放入一个Map中
     * 其中包括一个名为class的属性，属性值是Object的类名
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test01() throws Exception {
		Month month = new Month(1, "hanmeimei");
		Map map = BeanUtils.describe(month);
		Set keySet = map.keySet();
		for (Iterator iter = keySet.iterator(); iter.hasNext();) {
			Object element = (Object) iter.next();
			System.out.println("KeyClass:" + element.getClass().getName());
			System.out.println("ValueClass:"
					+ map.get(element).getClass().getName());
			System.out.print(element + "\t");
			System.out.print(map.get(element));
			System.out.println("\r\n");
		}
	}

	@Test
	public void test02() throws Exception {
		// static java.lang.String getProperty(java.lang.Object bean,
		// java.lang.String name)
		Month month = new Month(1, "Jan");

		try {
			System.out.println(BeanUtils.getProperty(month, "value"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test03() throws Exception {
		Month month = new Month(1, "Jan");

		try {
			System.out.println(BeanUtils.getIndexedProperty(month, "days", 1));
			System.out.println(BeanUtils.getIndexedProperty(month, "days[1]"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test04() throws Exception {
		Month month = new Month(1, "Jan");
		Month2 m = new Month2();
		BeanUtils.copyProperties(m, month);
		System.out.println(m.getName());
	}

	@Test
	public void test05() throws Exception {
		Month month = new Month(1, "Jan");
		Month2 m = new Month2();
		BeanUtils.copyProperty(m, "name", month);
		System.out.println(m.getName()+","+m.getValue());
	}

	@Test
	public void test06() throws Exception {
		//根据一个java.lang.Class以及相应的构造方法的参数，创建一个对象。
		Object obj=ConstructorUtils.invokeConstructor(Month.class, new Object[]{new Integer(1), "Jan"});
		Month month=(Month)obj;
		try {
		System.out.println(BeanUtils.getProperty(month,"value"));
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test07() throws Exception {
		Object[] args = { new Integer(1), "Jan" };
		Class[] argsType = { int.class, String.class };
		Object obj;
		obj = ConstructorUtils.invokeExactConstructor(Month.class, args,
				argsType);
		Month month = (Month) obj;
		System.out.println(BeanUtils.getProperty(month, "value"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test08() throws Exception {
		Month month = new Month(1, "hanmeimei");
		Month2 month2 = new Month2(); 
		Map map = BeanUtils.describe(month);
		BeanUtils.populate(month2, map);
		
		System.out.println(month2.getName());
	}

	@Test
	public void test09() throws Exception {

	}

	@Test
	public void test10() throws Exception {

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
