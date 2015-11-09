package basestrong.reflectExample;

import java.io.*;

public class MainTest {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		// IO流
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "src/reflectExample/config.txt"));
		//利用转换流 找到config.txt文件 
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				MainTest.class.getResourceAsStream("config.txt")));
		//分解步骤
//		InputStream in = MainTest.class.getResourceAsStream("config.txt");
//		BufferedReader reader = 
//			new BufferedReader(new InputStreamReader(in));

		String line = null;
		while ((line = reader.readLine()) != null) {
			Class cls = Class.forName(line);
			Object o = cls.newInstance();
		}
		reader.close();
	}

}
// 为什么方法中加void 就不会运行了---构造方法怎么能void 
// InputStream ??? 如何包装的 导错包了 
//Config.class ??? 此行是为了找到和 Config.class 或 MainTest.class在相同路径下的config.txt.