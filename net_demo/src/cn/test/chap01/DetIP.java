package cn.test.chap01;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class DetIP {
	
	@Test
	public void getIP() throws UnknownHostException {
		InetAddress ip = InetAddress.getByName("www.baidu.com");
		System.out.println(ip);
	}
	@Test
	public void getLocalhost() throws UnknownHostException {
		InetAddress myip = InetAddress.getLocalHost();
		System.out.println(myip);
	}
}
