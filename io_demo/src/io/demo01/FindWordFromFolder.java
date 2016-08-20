package io.demo01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class FindWordFromFolder {
	public static void main(String[] args) throws IOException {
		File dir =new File("E:\\travelsky\\HubRebook\\src\\"); 
			//getDir();
		list(dir);
	}

	private static void list(File dir) throws IOException {
		File[] subFiles = dir.listFiles();
		if (subFiles != null) {
			for (File subfile : subFiles) {
				copyFile(subfile);
				if (subfile.isDirectory())
					list(subfile);

			}
		}
	}
	
	private static void copyFile(File file) throws IOException {		
		if (file.getName().endsWith(".java") || file.getName().endsWith(".xml")) {
			LineNumberReader reader = new LineNumberReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null)
				if(line.contains("yyyy-mm-dd hh24:mi:ss") ){
					line = line.replaceAll("^\\s*", "");
//					System.out.println(file.getName()+"\t"+reader.getLineNumber()+"\t"+line);
					
					System.out.printf("%-30s,%-10s,%-100s",file.getName(),reader.getLineNumber()+"",line);
					System.out.println();
				}
			reader.close();
		} 
	}
	
	public static File getDir() throws IOException {
		System.out.println("dir:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String line = reader.readLine();
			File dir = new File(line);
			if (!dir.exists())
				System.out.println("quit:");
			else if (!dir.isDirectory())
				System.out.println("quit:");
			else
				return dir;
		}
	}
}