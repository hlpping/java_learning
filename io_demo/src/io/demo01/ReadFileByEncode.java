package io.demo01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class ReadFileByEncode {
	public static void main(String[] args) {
		File file = new File("E:\\temp\\access.log00817");
		String s = file2String(file, "GBK");
		System.out.println(s);
	}

	//�ı��ļ�ת��Ϊָ��������ַ���
	public static String file2String(File file, String encoding) {
		InputStreamReader reader = null;
		StringWriter writer = new StringWriter();
		try {
			if (encoding == null || "".equals(encoding.trim())) {
				reader = new InputStreamReader(new FileInputStream(file), encoding);
			} else {
				reader = new InputStreamReader(new FileInputStream(file));
			}
			// ��������д�������
			char[] buffer = new char[8192];
			int n = 0;
			while (-1 != (n = reader.read(buffer))) {
				writer.write(buffer, 0, n);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		// ����ת�����
		if (writer != null)
			return writer.toString();
		else
			return null;
	}

}
