package base.day21_Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSendDemo {
	public static void main(String[] args) throws IOException {
		// 要发送的数据
		// 创建发送端Socket, 使用默认IP地址和端口号
		// 创建发送端Packet, 需要指定4个参数, 字节数组(数据), 长度, IP, 端口号
		// 发送数据, 数据从packet发送到网络
		// 释放资源
		String data="hi hihi hih h";
		DatagramSocket socket=new DatagramSocket();
		DatagramPacket packet =new DatagramPacket(
			data.getBytes(),data.getBytes().length,
			InetAddress.getByName("127.0.0.1"),9999
		);
		socket.send(packet);
		socket.close();		
	}
}
