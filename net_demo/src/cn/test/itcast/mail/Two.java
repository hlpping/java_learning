package cn.test.itcast.mail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class Two {
	public static void main(String[] args) throws Exception {
		//1:必须指定服务器，通过资源文件的方式指定
		Properties p = new Properties();
		//指定服务器
		p.setProperty("mail.host","smtp.126.com");
		//auth login
		p.setProperty("mail.smtp.auth","true");
		//2:建立与126的连接
		Session sess = Session.getDefaultInstance(p,new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				PasswordAuthentication p = new PasswordAuthentication("wjme00","123456");
				return p;
			}
			
		});
		sess.setDebug(true);
		
		//3:建立一个Message即消息体
		MimeMessage msg = new MimeMessage(sess);
		//指定发送人
		msg.setFrom(new InternetAddress("wjme00@126.com "));
		//指定发给的人
		msg.setRecipient(RecipientType.TO,new InternetAddress("wjme00@sohu.com"));
		//设置主题
		msg.setSubject("这是测试发图片133999");
		msg.setSentDate(new Date());
		//设置正文
		
		//声明一个容器
		MimeMultipart mmp = new MimeMultipart();
		
		
		//声明一个内容主体
		MimeBodyPart part1 = new MimeBodyPart();
		part1.setContent("<font color='red'>带美女图的333</font>","text/html;charset=UTF-8");
		
		
		//再声明一个新的主体
		MimeBodyPart part2 = new MimeBodyPart();
		part2.setDataHandler(new DataHandler(new FileDataSource("./imgs/a.JPG")));
		part2.setFileName(MimeUtility.encodeText("张茵茵同学.jpg"));
		
		//将内容主体，放到容器中。
		mmp.addBodyPart(part1);
		mmp.addBodyPart(part2);
		
		//将容器放到MSG中
		msg.setContent(mmp);
		
		//发送
		Transport.send(msg);
		
		System.err.println("over");
	}
}
