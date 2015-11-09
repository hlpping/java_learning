package base.day16_IO3_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetDir {
	public static File getDir() throws IOException {
		System.out.println("请输入一个文件夹路径:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String line = reader.readLine();
			File dir = new File(line);
			if (!dir.exists())
				System.out.println("输入的路径不存在, 请重新输入, 退出输入quit:");
			else if (!dir.isDirectory())
				System.out.println("输入的不是文件夹路径, 请重新输入, 退出输入quit:");
			else
				return dir;
		}
	}
}
