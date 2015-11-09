package base.day21_Udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/*
 * 开启两条线程
 * 线程1中负责接收, run方法中写接收的代码
 * 线程2中负责发送, run方法中写发送的代码
 */
public class UdpChat {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				try {
					DatagramSocket socket = new DatagramSocket(9999);
					while (true) {
						DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
						socket.receive(packet);
						byte[] data = packet.getData();
						int len = packet.getLength();
						String ip = packet.getAddress().getHostAddress();
						int port = packet.getPort();
						System.out.println(getDateString() + ip + ":" + port + " 对我说:");
						String msg = new String(data, 0, len);
						System.out.println(msg);
						if ("bye".equals(msg))
							break;
					}
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start(); // 接收线程

		new Thread(new Runnable() {
			public void run() {
				try {
					DatagramSocket socket = new DatagramSocket();
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					while (true) {
						String line = reader.readLine();
						DatagramPacket packet = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("255.255.255.255"), 9999);
						socket.send(packet);
						if ("bye".equals(line))
							break;
					}
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start(); // 发送线程
	}
	public static String getDateString() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		String dateStr = format.format(date);
		return dateStr;
	}
}
