package xml.pre1;

public class XMLConfig {
	
	// 配置文件的路径信息
	public static String menu = 
		Thread.currentThread().getContextClassLoader().
		getResource("").getPath().replace("%20"," ");

	// 配置文件server.xml的路径加文件名信息
	public static String config = menu+ "/pre1/server.xml";

}
