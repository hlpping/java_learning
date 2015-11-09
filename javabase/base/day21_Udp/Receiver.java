package base.day21_Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {
	//循环接收, 直到接收到"bye"时退出
	// 创建接收端Socket
			// 循环
				// 创建接收端Packet
				// 接收			
				// 获取数据
				// 获取长度
				// 有可能获取不到, 或者造成传输速度非常低			
				// 组装成字符串打印			
				// 判断, 如果是"bye", break			
			// 释放资源
	public static void main(String[] args) throws IOException {
		DatagramSocket socket =new DatagramSocket(9999);
		while(true){
			DatagramPacket packet =new DatagramPacket(new byte[1024], 1024);
			socket.receive(packet);
			byte[] data = packet.getData();
			int len = packet.getLength();
			String ip = packet.getAddress().getHostAddress();
			int port = packet.getPort();
			System.out.println(ip + ":" + port);
			
			String msg =new String(data,0,len);
			System.out.println(msg);
			if ("bye".equals(msg))
				break;
		}
		socket.close();
	}
}
