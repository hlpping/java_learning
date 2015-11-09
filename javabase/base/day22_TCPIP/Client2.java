package base.day22_TCPIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client2 {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 9999);
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream out = new PrintStream(socket.getOutputStream(), true);
		
		System.out.println(reader.readLine());
		out.println("我要报名就业班.");
		System.out.println(reader.readLine());
		out.println("好吧, 那我报名下一期.");
		
		socket.close();
	}
}
