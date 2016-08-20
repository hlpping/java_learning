package cn.test.itcast.mail;

import java.util.Properties;

import javax.mail.Session;

public class Three {
	public static void main(String[] args) {
		
		Properties p =new Properties();
		
		p.setProperty("mail.host", "127.0.0.1");
		p.setProperty("mail.smtp.auth", "true");
		
		Session sess =Session.getDefaultInstance(p);
		sess.setDebug(true);
		
		System.out.println(sess);

	}

}
