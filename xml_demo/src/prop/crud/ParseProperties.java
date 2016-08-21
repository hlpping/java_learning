package prop.crud;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ParseProperties {
	
	public static Map<String,String> iteratorAll(InputStream inputstream) throws IOException{
		
		Map<String,String> map = new HashMap<String, String>();
		
		Properties properties = new Properties();
		properties.load(inputstream);
		Enumeration<String> enumvalue = (Enumeration<String>) properties.propertyNames();
		while (enumvalue.hasMoreElements()){
			String key = enumvalue.nextElement(); 
			map.put(key, properties.getProperty(key));
		}
		
		return map;
	}
	
	public static String getValueByKey(InputStream inputstream,String keyword) throws IOException{
		
		Properties properties = new Properties();
		properties.load(inputstream);
		return properties.getProperty(keyword).trim();
	}
	
	
	public static void insert(String file,String key,String value) throws IOException, URISyntaxException{
		
		URL url = ClassLoader.getSystemResource(file);
		File f = new File(url.toURI());
		InputStream is = new FileInputStream(f);
		
		Properties properties = new Properties();
		properties.load(is);
		properties.setProperty(key, value);
		OutputStream fos = new FileOutputStream(f);
		properties.store(fos, null);
		fos.flush();
		fos.close();
		is.close();
	}
	
	
	public static void delete(String file,String key) throws URISyntaxException, IOException{
		
		URL url = ClassLoader.getSystemResource(file);
		File f = new File(url.toURI());
		InputStream is = new FileInputStream(f);
		
		Properties properties = new Properties();
		properties.load(is);
		properties.remove(key);
		OutputStream fos = new FileOutputStream(f);
		properties.store(fos, null);
		fos.flush();
		fos.close();
		is.close();
		
	}
	
	
	public static InputStream get(String file) {
		return ClassLoader.getSystemResourceAsStream(file); 
	}

	public static InputStream get(File file) throws FileNotFoundException {
		return  new FileInputStream(file);
	}

	public static InputStream get(byte[] b) {
		return new ByteArrayInputStream(b);
	}
	
}
