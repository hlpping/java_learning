package base.day22_TCPIP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo {
	public static void main(String[] args) throws IOException {
		// 创建服务端, 指定端口号, 服务器启动监听该端口
		// 服务器等待接受客户端请求, 如未接收到, 程序阻塞
		// 获取服务端输入流, 可以读取客户端输出流中的数据
		// 获取服务端输出流, 可以向客户端输入流写出数据
		// 输出数据
		// 读取数据
		// 输出数据
		// 释放资源

		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();

		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();

		out.write("欢迎拨打传智播客热线, 请问需要什么帮助?".getBytes());

		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String msg = new String(buf, 0, len);
		System.out.println(msg);

		out.write("不好意思, 这期报满了, 下次早点吧.".getBytes());

		socket.close();
		serverSocket.close();
	}
}
