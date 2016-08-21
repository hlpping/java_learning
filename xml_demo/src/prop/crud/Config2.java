package prop.crud;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

public class Config2 {

	
	public static void main(String[] args) throws IOException, URISyntaxException {
//		insert();
//		delete();
		getByKey();
	}
	
//	根据key值在资源文件中查询value�?
	@SuppressWarnings("unchecked")
	public static void getByKey() throws IOException{
		Properties properties = new Properties();
		InputStream inputstream = ClassLoader.getSystemResourceAsStream("prop/crud/info.properties"); 
		
// 		InputStream  inputstream =this.getClass().getResourceAsStream("/info.properties");
		
		properties.load(inputstream);
		
		Enumeration<String> enumvalue = (Enumeration<String>) properties.propertyNames();
		
		while (enumvalue.hasMoreElements()){
			String key = enumvalue.nextElement(); 
			System.out.println(key + " : " + properties.getProperty(key));
		}
	}
	
	public static void insert() throws IOException, URISyntaxException{
		Properties properties = new Properties();
		URL url = ClassLoader.getSystemResource("prop/crud/info.properties");
		File file = new File(url.toURI());
		InputStream is = new FileInputStream(file);
		properties.load(is);
		properties.setProperty("key", "value");
		OutputStream fos = new FileOutputStream(file);
		properties.store(fos, null);
		fos.flush();
		is.close();
		
	}
	
	public static void delete() throws URISyntaxException, IOException{
		Properties properties = new Properties();
		File file = new File(ClassLoader.getSystemResource("prop/crud/info.properties").toURI());
		InputStream is = new FileInputStream(file);
		properties.load(is);
		properties.remove("key");
		OutputStream fos = new FileOutputStream(file);
		properties.store(fos, null);
		is.close();
		fos.flush();
		fos.close();
		
	}
	                            
	                            
}
