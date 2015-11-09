package basestrong2.beanutils2;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;


public class App {
	
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

		//vo对象 接收jsp页面表单的数据,模拟
		EmpForm empForm=new EmpForm();
		empForm.setId("1");
		empForm.setName("zhang");
		empForm.setSex("男");
		empForm.setTel("13467897666");
		empForm.setBirthday("2010-12-09");
		
		//po对象
		Emp emp=new Emp();
		
		/*
		 * 注册转化器:
		 * ConvertUtils.register(converter, clazz)
		 *   * converter:要注册的转化器
		 *   * clazz:要转化的数据类型
		 */
		ConvertUtils.register(new DateConverter(), java.util.Date.class);
		
		/*
		 * vo对象的值复制到po中,使用beanUtils处理
		 *  BeanUtils.copyProperties(emp, empForm);
		 *    * 完成bean与bean之间属性的赋值
		 *    * emp:目的的javaBean
		 *    * empForm:源javaBean
		 *    * 条件:
		 *       * 要求,两个javaBean中的属性名称要相同,必须相同,才能复制
		 *              两个javaBean中的属性个数多少没有影响,只找匹配的
		 */
		BeanUtils.copyProperties(emp, empForm);
		
	   //测试,输出emp对象的数据
  	   System.out.println(emp.getId());
  	   System.out.println(emp.getName());
  	   System.out.println(emp.getBirthday());
	}
}
