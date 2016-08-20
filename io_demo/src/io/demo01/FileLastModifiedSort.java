package io.demo01;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class FileLastModifiedSort {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = new File("E:/Company");
		File[] files = dir.listFiles();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Arrays.sort(files, new LastModifiedFileComparator());
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			System.out.println(file.getName() + "\t"
					+ sdf.format(new Date(file.lastModified())));
		}
	}
}

class LastModifiedFileComparator implements Comparator {
	public int compare(Object object1, Object object2) {
		File file1 = (File) object1;
		File file2 = (File) object2;
		long result = file1.lastModified() - file2.lastModified();
		if (result < 0) {
			return -1;
		} else if (result > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}