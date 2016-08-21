package cn.test.ftp.demo01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

public class FTPDownload {

	/** 本地目录 */
	static String local = "E:\\temp\\";

	static String ip = "10.6.168.137";
	static String user = "hotelawr";
	static String password = "awr.223";
	static String directory = "/sys_back/allsys/awr/HOTEL/20120514/";

	public static void main(String[] args) throws SocketException, IOException {
		boolean boo = downFileByFilename("HOTEL_2012051400_hour.html.gz");
		System.out.println(boo);
	}

	public static boolean downFileByFilename(String filename) throws SocketException, IOException {

		// 判断此文件夹是否存在
		File file = new File(local);
		if (!file.exists())
			return false;
		// 判断这个目录是否存在,还有是不是以斜线结尾的

		boolean boo = false;
		FTPClient client = new FTPClient();
		client.setConnectTimeout(30000);

		// 连接ftp
		client.connect(ip);
		int replyCode = client.getReplyCode();
		if (!FTPReply.isPositiveCompletion(replyCode)) {
			client.disconnect();
			return boo;
		}
		replyCode = client.getReplyCode();
		if (!FTPReply.isPositiveCompletion(replyCode)) {
			client.quit();
			return boo;
		}

		if (client.login(user, password)) {
			// 以2开头的返回值就会为真
			if (!FTPReply.isPositiveCompletion(client.getReplyCode())) {
				client.disconnect();
				System.out.println("连接ftp失败");
			}
			/** ftp server system type */
			FTPClientConfig ftpClientConfig = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
			/** server language */
			ftpClientConfig.setServerLanguageCode("zh");
			/** server time zone */
			ftpClientConfig.setServerTimeZoneId("Asia/Shanghai");
			/** ftp transfer mode in binary */
			client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
			/** receive buffer size */
			client.setReceiveBufferSize(524288);
			client.configure(ftpClientConfig);
			client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
			client.setFileType(FTP.BINARY_FILE_TYPE);
			client.changeWorkingDirectory(directory);// 转移到FTP服务器目录
			// 下载到本地
			boo = client.retrieveFile(filename, new FileOutputStream(local + filename));
		}
		return boo;
	}

}
