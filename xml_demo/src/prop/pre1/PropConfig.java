package prop.pre1;

public class PropConfig {
	
	//配置文件的路径信息
	public static String menu = 
		Thread.currentThread().getContextClassLoader().
		getResource("").getPath().replace("%20", " ");
	//配置文件的路径加文件名信息
	public static String config =menu+ "/prop/pre1/config.properties";
}
