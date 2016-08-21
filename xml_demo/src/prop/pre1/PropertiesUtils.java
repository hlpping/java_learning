package prop.pre1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * 读取Properties文件的帮助类
 */
public class PropertiesUtils {
	/**
	 * 获取全文的键值
	 * @param filePath
	 * @return
	 */
	public static List<String> readProperties(String filePath) {
		List<String> keyList = new ArrayList<String>();
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String property = props.getProperty(key).trim();
				 System.out.println(key +" : "+ property);
				keyList.add(property);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(keyList);
		return keyList;
	}
	/**
	 * 获取以某个关键字为键的集合
	 * @param filePath 
	 * @param keyword
	 * @return
	 */
	public static List<String> readPropertiesByKeys(String filePath,String keyword) {
		List<String> keyList = new ArrayList<String>();
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				//以关键字开始的键值
				if(key.trim().startsWith(keyword.trim())){
					String property = props.getProperty(key).trim();
					 System.out.println(key +" : "+ property);
					keyList.add(property);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(keyList);
		return keyList;
	}
	/**
	 * 获取单个键值
	 * @param filePath
	 * @param keyword
	 * @return
	 */
	public static String readPropertiesByKey(String filePath,String keyword) {
		Properties props = new Properties();
		String property=null;
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
			property =props.getProperty(keyword);
			System.out.println(keyword +" : "+ property);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return property;
	}

}
