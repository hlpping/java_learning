package cn.net.chap06;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * 获取IP地址
 * 
 * @author shuang
 * 
 */
public class InterGetAddr {

	@Test
	public void getIPbyName() {
		// String addr = "www.oreilly.com";
		String addr = "208.201.239.100";
		try {
			InetAddress address = InetAddress.getByName(addr);
			System.out.println(address.getHostName());
		} catch (UnknownHostException e) {
			System.out.println("Could not find " + addr);
			e.printStackTrace();
		}
	}

	@Test
	public void getAllIPbyName() {
		String addr = "www.baidu.com";
		try {
			InetAddress[] address = InetAddress.getAllByName(addr);
			for (int i = 0; i < address.length; i++) {
				System.out.println(address[i]);
			}
		} catch (UnknownHostException e) {
			System.out.println("Could not find " + addr);
			e.printStackTrace();
		}
	}

	@Test
	public void getMyIP() {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address);
			System.out.println(address.toString());
		} catch (UnknownHostException e) {
			System.out.println("Could not find my ip");
			e.printStackTrace();
		}
	}

	@Test
	public void getName() {
		for (int i = 0; i < 256; i++) {
			String addr = "208.201.239." + i;
			try {
				InetAddress address = InetAddress.getByName(addr);
				System.out.println(address.getHostName());
			} catch (UnknownHostException e) {
				System.out.println("Could not find " + addr);
				// e.printStackTrace();
			}

		}
	}

	@Test
	public void getOtherName() {
		// String addr = "www.oreilly.com";
		String addr = "208.201.239.100";
		try {
			// InetAddress address = InetAddress.getByName(addr);
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address);
			System.out.println(address.getAddress());
			System.out.println(address.getHostAddress());
			System.out.println(address.getHostName());
		} catch (UnknownHostException e) {
			System.out.println("Could not find " + addr);
			e.printStackTrace();
		}
	}

	@Test
	public void getOtherName2() {
		try {
			InetAddress address = InetAddress.getLocalHost();
			byte[] b = address.getAddress();

			for (int i = 0; i < b.length; i++) {
//				System.out.print(b[i] + " ");
				int bi = b[i];
				if (b[i] < 0) {
					bi = b[i] + 256;
				}
				System.out.print(bi + " ");
			}

		} catch (UnknownHostException e) {
			System.out.println("Could not find localhost");
			e.printStackTrace();
		}
	}
}
