package io.demo01;

import java.io.File;

import org.junit.Test;

/**
 * ���Ŀ���ļ����µ��ļ�
 * @author yshzhao
 * @version 2013-5-10
 */
public class ListFile {
	
	@Test
	public void test01() throws Exception{
		String path ="E:\\Workspaces\\temp2test\\test-temp\\test\\src\\time";
		String ext=".java";
		list(path,ext);
	}
	
	public static void list(String path,String ext) throws Exception{
		File file = new File(path);
		if( !file.isDirectory()){
			throw new Exception("�������·�������ļ���");
		}
		String[] list=file.list();
		if(list.length >0){
			for(String s : list){
				File f=new File(file,s);
				if(ext!=null && !ext.trim().equals("")){
					if(f.isFile()&&s.endsWith(ext))
						System.out.println(s);			
					
				}else{
					if(f.isFile())
						System.out.println(s);
				}
			}
		}
	}
	
	/**
	 * �ж��ļ��Ƿ����
	 * @param fileName �磺E:\\log.txt ע����ѭjava�ķ�б��
	 * @return File����
	 */
	public static File loadFile(String fileName){
		File file =new File(fileName);
		boolean isExist =file.exists();
		System.out.println("file is exist "+ isExist);
		return file;
	}
}
