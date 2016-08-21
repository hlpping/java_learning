package cn.test.zip.demo01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile {
	public static void main(String[] args) throws IOException {

		// System.out.println(zip("E:\\Z_temp\\down\\access.log00176", "access.log00176.zip"));
		System.out.println(zip("access.log00176", "access.log00176.zip"));

	}

	public static boolean zip(String fileName, String zipfile) throws IOException {
		boolean bf = true;
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("zip[ZipFile] --------file not exist：" + fileName);
			bf = false;
		} else {
			// 创建文件输入流对象
			// 创建文件输出流对象
			// 创建ZIP数据输出流对象
			FileInputStream in = null;
			FileOutputStream out = null;
			ZipOutputStream zipOut = null;
			try {
				in = new FileInputStream(fileName); // 0
				out = new FileOutputStream(zipfile); // 1
				zipOut = new ZipOutputStream(out);
				// 创建指向压缩原始文件的入口
				ZipEntry entry = new ZipEntry(fileName.substring(fileName.lastIndexOf('/') + 1, fileName.length())); // 0
				zipOut.putNextEntry(entry);
				// 向压缩文件中输出数据
				int nNumber;
				byte[] buffer = new byte[512];
				while ((nNumber = in.read(buffer)) != -1)
					zipOut.write(buffer, 0, nNumber);

			} catch (IOException e) {
				System.out.println("zip[ZipFile] ------生成失败：" + e.getMessage());
				bf = false;
			} finally {
				// 关闭创建的流对象
				zipOut.close();
				out.close();
				in.close();
			}
		}
		file = null;
		return bf;
	}
}
