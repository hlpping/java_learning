package basestrong2.beanutils1;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class App2 {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

		//vo对象 接收jsp页面表单的数据,模拟
		EmpForm empForm=new EmpForm();
		empForm.setId("1");
		empForm.setName("zhang");
		empForm.setSex("男");
		empForm.setTel("13467897666");
		
		//po对象
		Emp emp=new Emp();
		
		/*
		 * vo对象的值复制到po中,使用beanUtils处理
		 *  BeanUtils.copyProperties(emp, empForm);
		 *    * 完成bean与bean之间属性的赋值
		 *    * emp:目的的javaBean
		 *    * empForm:源javaBean
		 *    * 条件:
		 *       * 要求,两个javaBean中的属性名称要相同,必须相同,才能复制
		 */
		BeanUtils.copyProperties(emp, empForm);
		
	   //测试,输出emp对象的数据
  	   System.out.println(emp.getId());
  	   System.out.println(emp.getName());
		
	}

}
