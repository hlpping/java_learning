package base.day14_IO1;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CloseUtil {
	public static void close(Reader reader, Writer writer) {
		try {
			if (reader != null)
				reader.close();			
		} catch (IOException e) {
			e.printStackTrace();			
		}finally{
			try {
				if(writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
