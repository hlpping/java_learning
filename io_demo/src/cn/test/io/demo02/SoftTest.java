package cn.test.io.demo02;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SoftTest {
	/*
	 * 编写一个程序，记录该程序运行次数。运行满足5次，就提示用户“软件试用期限已到”；
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("intput\\times.txt")); // 定义IO流读取times.txt文件
		String line = reader.readLine(); // 读取一行
		reader.close();
		int times = Integer.parseInt(line); // 将读取到的内容转成数字
		if (times > 0) { // 判断这个数字是否大于0, 如果大于0, 那么提示软件可以使用, 显示试用次数, 将这个数字-1, 写回文件
			System.out.println("欢迎使用试用版, 剩余使用次数: " + times--);
			FileWriter writer = new FileWriter("times.txt");
			writer.write(times + ""); // 不能直接写times, 如果直接写times是码表中对应的字符
			writer.close();
		} else { // 如果等于0, 那么提示软件试用期已到
			System.out.println("软件试用期已到, 请上网搜索注册码.");
		}
	}
	// 在创建IO输出流时, 会覆盖原有文件. 
	// 使用字符流写出一个int值时, 是将int值转为char写出的. 我们如果想写出一个5, 不是使用writer.write(5), 而是写出writer.write("5")

}
