package cn.test.ssh.demo01;

import java.io.IOException;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;

public class sshDown {

	static String serverip = "10.6.156.77";
	static String username = "hotelftp";
	static String password = "hotelftp123";
	static String logcategory = "/opt/app/bea/wls103/user_projects/domains/hoteldomain/servers/sohoto77/logs/";
	static String localdir = "E://temp//";

	public static void main(String[] args) {
		System.out.println(downFile("access.log00817"));
	}

	public static boolean downFile(String filename) {
		// 处理服务器目录,并组织文件的路径
		if (!logcategory.endsWith("/")) {
			logcategory = logcategory + "/" + filename;
		} else
			logcategory = logcategory + filename;

		boolean boo = false;
		Connection conn = null;
		try {
			conn = new Connection(serverip);
			conn.connect();
			boolean login = conn.authenticateWithPassword(username, password);
			if (login) {
				SCPClient scpClient = conn.createSCPClient();
				scpClient.get(logcategory, localdir);
				boo = true;
				return boo;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
			return boo;
		}
	}

}
