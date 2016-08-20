package cn.test.itcast.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class One {
	public static void main(String[] args) throws Exception {
		//1:必须指定服务器，通过资源文件的方式指定
		Properties p = new Properties();
		//指定服务器
		p.setProperty("mail.host","127.0.0.1");
		//auth login
		p.setProperty("mail.smtp.auth","true");
		//2:建立与126的连接
		Session sess = Session.getDefaultInstance(p,new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				PasswordAuthentication p = new PasswordAuthentication("aaa","123");
				return p;
			}
			
		});
		sess.setDebug(true);
		
		//3:建立一个Message即消息体
		MimeMessage msg = new MimeMessage(sess);
		//指定发送人
		msg.setFrom(new InternetAddress("aaa@abc.com "));
		//指定发给的人
		msg.setRecipient(RecipientType.TO,new InternetAddress("bbb@abc.com"));
		//设置主题
		msg.setSubject("这是测试");
		msg.setSentDate(new Date());
		//设置正文
		msg.setContent("Hello这也测试的正文<a href='http://www.baidu.com'>BaiDu</a>","text/html;charset=UTF-8");
		//发送
		Transport.send(msg);
		
		System.err.println("over");
	}
}
