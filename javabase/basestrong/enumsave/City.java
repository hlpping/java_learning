package basestrong.enumsave;

import java.util.HashMap;
import java.util.Map;
/**
 * 具有实例缓存的枚举类
 * @author Administrator
 *
 */
public class City {
	
	private City(){}
	private static Map<String,City> map =new HashMap<String,City>();
	
	public static City getCity(String name){
		City city =map.get(name);
		if(city==null){		//判断是否为空，如果为空没有请求过。
			city=new City();
			map.put(name, city);
		}
		return city;		
	}
	
	
	
	
	
	
}
