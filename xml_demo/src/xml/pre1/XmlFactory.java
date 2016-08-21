package xml.pre1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlFactory {
	private static Document dom;
	private static File file;
	static {
		try {
			file = new File(XMLConfig.config);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Document getDom() {
		return dom;
	}

	public static String FTPHost;
	public static String FTPUser;
	public static String FTPPassword;
	public static String FTPRemoteDirectory;
	public static String FTPLocalDirectory;

	public static void getMessage() {
		Document dom = XmlFactory.getDom();
		NodeList list = dom.getElementsByTagName("ftpserver");
		Element e = (Element) list.item(0);
		FTPHost = e.getElementsByTagName("server").item(0).getTextContent();
		FTPUser = e.getElementsByTagName("user").item(0).getTextContent();
		FTPPassword = e.getElementsByTagName("password").item(0)
				.getTextContent();
		FTPRemoteDirectory = e.getElementsByTagName("remotedirectory").item(0).getTextContent();
		FTPLocalDirectory = e.getElementsByTagName("localdirectory").item(0).getTextContent();
	}
	public static void main(String[] args) {
		getMessage();
		System.out.println(FTPHost);
		System.out.println(FTPUser);
	}
}
