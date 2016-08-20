package cn.test.itcast.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Four {
	public static void main(String[] args) throws AddressException, MessagingException {
		
		Properties p =new Properties();
		
		p.setProperty("mail.host", "127.0.0.1");
		p.setProperty("mail.smtp.auth", "true");
		
		Session sess =Session.getDefaultInstance(p,new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				PasswordAuthentication p = new PasswordAuthentication("aaa","123");
				return p;
			}
			
		});
		sess.setDebug(true);
		
		System.out.println(sess);
		
		MimeMessage msg=new MimeMessage(sess);
		msg.setFrom(new InternetAddress("aaa@abc.com"));
		msg.setRecipient(RecipientType.TO, new InternetAddress("bbb@abc.com"));
		msg.setSubject("这是测试");
		msg.setContent("Hello这也测试的正文<a href='http://www.baidu.com'>BaiDu</a>","text/html;charset=UTF-8");
		
		msg.setSentDate(new Date());
		Transport.send(msg);
		System.out.println("over");
	}

}

