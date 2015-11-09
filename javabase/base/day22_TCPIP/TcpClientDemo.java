package base.day22_TCPIP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClientDemo {
	public static void main(String[] args) throws IOException, InterruptedException {
		// 创建客户端, 指定ip和port, 并连接
		// 获取客户端输入流, 可以读取到服务端输出流中输出的数据
		// 获取客户端输出流, 可以向服务端的输入流输出数据
		// 读取数据
		// 输出数据	
		// 读取数据
		// 释放资源		
		
		Socket socket = new Socket("192.168.1.251", 9999);
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();

		byte[] buf = new byte[1024]; // 数组用来存储数据
		int len = in.read(buf); // 从流中读取数据到数组, 用len记住有效数据的长度
		String msg = new String(buf, 0, len); // 将读取到的数据转为字符串
		System.out.println(msg);

		out.write("我要报名就业班.".getBytes());
		len = in.read(buf);
		msg = new String(buf, 0, len);
		System.out.println(msg);
		socket.close();
	}
}
