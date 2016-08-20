package cn.test.nio.demo01;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class Search {
	public static void main(String[] args) throws IOException {

		if (args.length < 2) {
			System.out.println("usage: Java Search <file> <string>");
			return;
		}

		Charset charset = Charset.forName("GB18030");
		CharsetDecoder decoder = charset.newDecoder();
		// 如果与中文无关，此二句及其后相关语句可刪除

		String fileName = System.getProperty("user.dir") + System.getProperty("file.separator") + args[0];

		try {

			FileInputStream fis = new FileInputStream(fileName);
			FileChannel fc = fis.getChannel();

			int sz = (int) fc.size();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, sz);

			CharBuffer cb = decoder.decode(bb);

			String s = String.valueOf(cb);

			int n = s.indexOf(args[1]);
			if (n > -1)
				System.out.println(args[1] + " --- " + n);
			else
				System.out.println(args[1] + " --- not found! ");

			fc.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}