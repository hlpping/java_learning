package basestrong2.beanutils2;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;

/**
 * 自定义一个转化器
 *   * 实现org.apache.commons.beanutils.Converter接
 *   * 该转化器要完成从String类型(格式:yyyy-MM-dd)---->java.util.Date.class类型的转化
 *     * 例如：2010-12-09 到   java.util.Date类型 
 *   * 该方法的返回值就是转化后的值,本例就是Emp中private java.util.Date birthday的值  
 */
public class DateConverter  implements Converter {
	
	/**
	 * @param clazz:要转化的数据类型   java.util.Date.class
	 * @param value:要转化的值   2010-12-09
	 * @return
	 */
	public Object convert(Class clazz, Object value) {
		System.out.println(clazz);
		System.out.println(value);
		if(value==null){
			return null;
		}
		if(clazz==null){
			return null;
		}
		if(clazz!=java.util.Date.class){
			return null;
		}
  
		if(value  instanceof java.lang.String){
			try {
				String source=value.toString();
				SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
				return sf.parse(source);
			} catch (ParseException e) {
			  throw new RuntimeException("您输入数据不能转化为日期类型");
			}
		}
		
		return null;
	}
}
