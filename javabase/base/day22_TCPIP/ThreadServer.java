package base.day22_TCPIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(9999);
		while (true) { // 循环接收客户端请求
			final Socket socket = serverSocket.accept();

			new Thread(new Runnable() { // 每接收到一个请求, 用一条线程去处理
						public void run() {
							try {
								BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
								PrintStream out = new PrintStream(socket.getOutputStream(), true);

								String ip = socket.getInetAddress().getHostAddress();
								int port = socket.getPort();

								out.println("欢迎拨打传智播客热线, 请问需要什么帮助?");
								System.out.println(ip + ":" + port + ": " + reader.readLine());
								out.println("不好意思, 这期报满了, 下次早点吧.");
								System.out.println(ip + ":" + port + ": " + reader.readLine());
								socket.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}).start();
		}
	}
}
