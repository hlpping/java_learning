package cn.test.ftp.demo01;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FTPList {

	static String ip = "10.6.168.137";
	static String user = "hotelawr";
	static String password = "awr.223";
	static String directory = "/sys_back/allsys/awr/HOTEL/20120514";

	public static void main(String[] args) {
		FTPFile[] files = listFile();
		
		if(files !=null && files.length>0){
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName() + "\t" + files[i].getSize());
			}
		}
	}

	private static FTPFile[] listFile() {
		FTPClient client = new FTPClient();
		client.setDataTimeout(60000);
		client.setConnectTimeout(60000);
		FTPFile[] files = null;
		try {
			client.connect(ip);
			client.login(user, password);
			files = client.listFiles(directory);
			client.logout();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (client.isConnected())
					client.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return files;
	}

}
