package base.day22_TCPIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();

		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream out = new PrintStream(socket.getOutputStream(), true);

		out.println("欢迎拨打传智播客热线, 请问需要什么帮助?");
		System.out.println(reader.readLine());
		out.println("不好意思, 这期报满了, 下次早点吧.");
		System.out.println(reader.readLine());

		socket.close();
		serverSocket.close();		
	}
}
