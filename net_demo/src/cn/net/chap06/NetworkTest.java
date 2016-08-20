package cn.net.chap06;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import org.junit.Test;

public class NetworkTest {
	
	@Test
	public void test1(){
		try {
			NetworkInterface ni = NetworkInterface.getByName("eth0");
			if(ni==null){
				System.err.println("no such inteface: eth0");
			}else
				System.out.println(ni.getDisplayName());
		} catch (SocketException e) {
			System.err.println("Could not list socket.");
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2(){
		try {
			InetAddress local = InetAddress.getByName("172.22.29.211");
			System.out.println(local);
			NetworkInterface ni = NetworkInterface.getByName("172.22.29.211");
			if(ni==null){
				System.err.println("no such inteface: eth0");
			}else{
				System.out.println(ni.getDisplayName());
			}
		} catch (SocketException e) {
			System.err.println("Could not list socket.");
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() throws SocketException{
			Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces();
			while(ni.hasMoreElements()){
				System.out.println(ni.nextElement());
			}
	}
	
	@Test
	public void test4(){
		
	}
}
