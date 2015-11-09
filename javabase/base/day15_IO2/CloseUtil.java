package base.day15_IO2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CloseUtil {
	public static void close(InputStream in, OutputStream out) {
		try {
			if (in != null)
				in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if (out != null)
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
