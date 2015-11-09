package basestrong.propertise;

import java.util.Properties;

public class PropertiseDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Properties p = System.getProperties();
//		Enumeration e = p.keys();  //Iterator
//		while(e.hasMoreElements()){
//			String key = (String)e.nextElement();
//			String val = p.getProperty(key);
//			System.err.println(key+"==="+val);
//		}
		System.err.println("***************");
		String vv = p.getProperty("sun.jnu.encoding");
		System.err.println(vv);
		
		
		
		
		
		
	}

}
