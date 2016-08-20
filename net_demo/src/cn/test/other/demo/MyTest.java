package cn.test.other.demo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MyTest {

	public static void main(String[] args) {

		try {
//			String surl = "http://info.travelsky.com/";
//			String surl = "http://www.sohoto.com/";
			String surl = "http://10.6.183.57:9378/eTermServices/Insure/Logon.jsp";
			URL url = new URL(surl);
			URLConnection rulConnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;
			httpUrlConnection.setConnectTimeout(300000);
			httpUrlConnection.setReadTimeout(300000);
			httpUrlConnection.connect();
			String code = new Integer(httpUrlConnection.getResponseCode())
					.toString();
			String message = httpUrlConnection.getResponseMessage();
			System.out.println("getResponseCode code =" + code);
			System.out.println("getResponseMessage message =" + message);
			if (!code.startsWith("2")) {
				throw new Exception("ResponseCode is not begin with 2,code="
						+ code);
			}
			//getCurDateTime()
			System.out.println( "连接" + surl + "正常" );
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}

	}
}
