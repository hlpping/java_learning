package base.day22_TCPIP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client1 {
	public static void main(String[] args) throws IOException {
		Socket socket =new Socket("127.0.0.1",9999); 
		InputStream in =socket.getInputStream();
		OutputStream out =socket.getOutputStream();
		
		PrintStream ps=new PrintStream(out,true);
		ps.println("你好");
		socket.close();
	}
}
