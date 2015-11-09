package base.day14_IO1;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

public class CopyByLineNumberReader {
	public static void main(String[] args) throws IOException {
		LineNumberReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new LineNumberReader(new FileReader("source.txt"));
			writer = new BufferedWriter(new FileWriter("d:\\test.txt"));
			String line;
			while ((line = reader.readLine()) != null)
				writer.write(reader.getLineNumber() + ":" + line + "\r\n");
		} finally {
			CloseUtil.close(reader, writer);
		}
	}
}
