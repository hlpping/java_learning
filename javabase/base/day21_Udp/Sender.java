package base.day21_Udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 接收键盘输入, 收一行发送一行
 * 直到输入"bye"时退出
 */
public class Sender {
	// 创建发送端Socket
	// 创建BufferedReader
	// 循环
		// 读取一行
		// 创建Packet, 封装数据
		// 发送
		// 判断, 如果是"bye", 那么break
	// 释放资源
	public static void main(String[] args) throws IOException {
		DatagramSocket socket=new DatagramSocket();
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line =reader.readLine();
			DatagramPacket packet=new DatagramPacket(
					line.getBytes(), line.getBytes().length, 
					InetAddress.getByName("127.0.0.1"), 9999		
			);
			socket.send(packet);
			if ("bye".equals(line))
				break;
		}
		socket.close();
	}
}
