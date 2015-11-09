package base.day16_IO3_file;

import java.io.File;
import java.io.IOException;

/*
 * 5.删除文件夹
		接收用户输入一个文件夹路径, 将整个文件夹删除
 */
public class Test5 {
	public static void main(String[] args) throws IOException {
		File dir =GetDir.getDir();
		deleteDir(dir);
	}

	private static void deleteDir(File dir) {
		File[] subFiles =dir.listFiles();
		if(subFiles!=null){
			for(File subFile : subFiles){
				if(subFile.isFile())
					subFile.delete();
				else
					deleteDir(subFile);
			}
			dir.delete();	// 循环结束之后, 删除文件夹
		}
	}
}
