package cn.test.itcast.mail;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import sun.misc.BASE64Encoder;

public class EncodeTest {
	@Test
	public void testEncode01() {
		String name = "aaa";
		String pwd = "123";
		// 进行编码
		BASE64Encoder en = new BASE64Encoder();
		name = en.encode(name.getBytes());
		pwd = en.encode(pwd.getBytes());
		System.err.println(name);
		System.err.println(pwd);
	}

	@Test
	public void testEncode02() {

		for (int i = 0; i < 4; i++) {

			String responseXml = null;
			System.out.println("start");
			try {
				responseXml = java.net.URLDecoder.decode(null, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			} finally {
				System.out.println("ssss");
			}
			// System.out.println(responseXml);
		}

	}
}
