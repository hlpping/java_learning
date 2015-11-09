package base.day21_Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiveDemo {
	public static void main(String[] args) throws IOException {
		// 创建接收端Socket, 必须指定端口号
		// 创建接收端Packet, 需要指定2个参数. 字节数组(用来接受数据), 长度(数组用来存储数据的长度)
		// 接收数据, 数据从网络收到packet中, 在未收到时, 程序阻塞
		// 从packet中获取数据
		// 获取数据长度, 发送端Packet参数中指定的长度 
		// 将数据转为字符串
		// 释放资源
		
		DatagramSocket socket = new DatagramSocket(9999);
		DatagramPacket packet =new DatagramPacket(new byte[1024],1024);
		socket.receive(packet);
		byte[] data =packet.getData();
		int len =packet.getLength();
		String msg =new String(data,0,len);
		System.out.println(msg);
		socket.close();		
	}
}
