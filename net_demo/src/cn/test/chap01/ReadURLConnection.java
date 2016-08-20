package cn.test.chap01;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

public class ReadURLConnection {
	
	@Test
	public void TestUrlConnection() throws IOException {
		
		URL url = new URL("http://www2.sohoto.com/SOHOTO2/newLogin.jsp");
		URLConnection connection = url.openConnection();
		DataInputStream inputStream = new DataInputStream(connection.getInputStream());
		String inputline;
		while( (inputline=inputStream.readLine())!=null){
			System.out.println(inputline);
		}
		inputStream.close();
	}
	
	//protocol://hostname:/resourcename#auchor
	@Test
	public void getHTML() throws MalformedURLException, IOException {
		URL url = new URL("http://www.sohoto.com");
		DataInputStream dataInputStream = new DataInputStream(url.openStream());
		String inputLine;
		while( (inputLine = dataInputStream.readLine()) !=null){
			System.out.println(inputLine);
		}
		dataInputStream.close();
	}
}
