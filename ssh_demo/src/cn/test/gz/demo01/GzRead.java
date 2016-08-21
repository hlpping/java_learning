package cn.test.gz.demo01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.charset.Charset;

import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

public class GzRead {

	public static void main(String[] args) {
		readFile("commons-net-3.0.1-bin.tar.gz");
	}

	public static void readFile(String filename) {

		InputStream in = null;
		LineNumberReader reader = null;

		File file = new File(filename);
		if (!file.exists()) {
			return;
		}
		try {
			if (file.isFile()) {
				in = new FileInputStream(file);
				if (file.getName().endsWith(".gz")) {
					System.out.println(file.getName());
					in = new GzipCompressorInputStream(in);
				}
				reader = new LineNumberReader(new InputStreamReader(in, Charset.forName("GBK")));
				String line;

				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			}else{
				System.out.println("file["+filename+"] is not a file !");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
