package cn.test.ssh.demo01;

import java.io.IOException;
import java.util.List;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.SFTPv3DirectoryEntry;

public class sshList {
	static String serverip = "10.6.156.77";
	static String username = "hotelftp";
	static String password = "hotelftp123";
	static String logcategory = "/opt/app/bea/wls103/user_projects/domains/hoteldomain/servers/sohoto77/logs/";

	public static void main(String[] args) throws IOException {
		List<SFTPv3DirectoryEntry> list = listFile();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).filename + "\t" + list.get(i).attributes.atime);
		}
		System.out.println("Ok" + list.size());
	}

	public static List<SFTPv3DirectoryEntry> listFile() {

		Connection conn = null;
		SFTPv3Client client;
		List<SFTPv3DirectoryEntry> list = null;
		try {
			conn = new Connection(serverip);
			conn.connect();
			boolean login = conn.authenticateWithPassword(username, password);
			if (login) {
				client = new SFTPv3Client(conn);
				// String charset = Charset.forName("UTF-8").toString();
				// client.setCharset(charset);
				list = client.ls(logcategory.trim());

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			conn.close();
			return list;
		}
	}
}
