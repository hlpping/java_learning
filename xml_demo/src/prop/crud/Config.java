package prop.crud;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Config {
	
	public static final String path = System.getProperty("user.dir")+"\\config\\config.properties";
	
	public static Map<String, String> getAllProperties() throws IOException, URISyntaxException{
		Map<String, String> map = new HashMap<String, String>();
		File file = new File(path);
		InputStream is = new FileInputStream(file);
		
		Properties properties = new Properties();
		properties.load(is);
		Enumeration<String> enumvalue = (Enumeration<String>) properties.propertyNames();
		while (enumvalue.hasMoreElements()){
			String key = enumvalue.nextElement(); 
			String value = properties.getProperty(key);
			System.out.println(key + " : " + value);
			map.put(key, value);
		}
		return map;
	}
	
	public static void insert(String key,String value) throws IOException, URISyntaxException{
		File file = new File(path);
		InputStream is = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(is);
		properties.setProperty(key, value);
		OutputStream fos = new FileOutputStream(file);
		properties.store(fos, null);
		fos.flush();
		is.close();
		
	}
	
	public static void delete(String key) throws URISyntaxException, IOException{
		File file = new File(path);
		InputStream is = new FileInputStream(file);
		
		Properties properties = new Properties();
		properties.load(is);
		properties.remove(key);
		OutputStream fos = new FileOutputStream(file);
		properties.store(fos, null);
		is.close();
		fos.flush();
		fos.close();
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		System.out.println(System.getProperty("user.dir")+"\\config\\config.properties");
//		insert();
//		System.out.println("---------------");
//		delete("ad_key01");
		System.out.println("-------------");
		getAllProperties();
	}
	                            
}
