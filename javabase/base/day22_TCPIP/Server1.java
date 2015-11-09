package base.day22_TCPIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();

		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();

		// 为了方便度字符, 而且一次读一行, 用BufferedReader包装
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(reader);
		System.out.println(br.readLine());

		socket.close();
		serverSocket.close();		
	}
}
