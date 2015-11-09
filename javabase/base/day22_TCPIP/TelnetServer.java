package base.day22_TCPIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TelnetServer {
	/*
	 * 服务器接收telnet发送的一行字符串, 将其翻转, 输出回去
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		while (true) {
			final Socket socket = serverSocket.accept();

			new Thread(new Runnable() {
				public void run() {
					try {
						BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String line = reader.readLine(); // 读取一行
						StringBuilder sb = new StringBuilder();
						sb.append(line);
						sb.reverse(); // 反转
						socket.getOutputStream().write(sb.toString().getBytes()); // 写回去
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}

//abc\r\n		abc		cba
//abd\r\n		abd		dba
//abd\bc\r\n	abd\bc	c\bdba