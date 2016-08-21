package day2.connect;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;
/**
 * 本方法用于获取数据库连接 
 * 数据库信息从配置文件中读取
 * 读取配置文件有两种方式
 * 1.cl.getResource("db.properties");
 * 2.cl.getResource(DbUtilsConfig.CONFIG);
 * 
 * 需要配置文件:db.properties 在src目录下
 * 
 * @author shuang
 * @version 1.0 Oct 28, 2011
 */
public class DbUtils {
	
	private static Connection con;
	static{
		try{			
			Properties p = new Properties();				//1:用资源文件,读取
			
			ClassLoader cl = DbUtils.class.getClassLoader();	//2:通过Load方法加载资源文件
																//2.1用类加载器读取classpath下的资源文件
			URL u = cl.getResource(DbUtilsConfig.CONFIG);		//2.2读取资源文件
//			URL u = cl.getResource("db.properties");		//2.2读取资源文件
			
			System.err.println(">>"+u.getPath());				//2.3URL就是一个文件的路径,day18/
			File f = new File(u.getPath());			
			p.load(new FileInputStream(f));						//3:加载资源文件
			
			String driver = p.getProperty("driver");			//4:获取driver等属性所对应的值 
			String url    = p.getProperty("url");
			String name = p.getProperty("name");
			String pwd = p.getProperty("pwd");			
					
			Class.forName(driver);								//5:开始与数据库建连接	
			con = DriverManager.getConnection(url,name,pwd);
			System.out.println(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 书写静态方法返回Connection的实例
	 */
	public static Connection getConn(){
		return con;
	}
	
	@Test
	public void testconnection() throws Exception{	
//		DbUtils dd;
		
		Connection con = DbUtils.getConn();
		System.out.println(con);
	}
	
	
	
}
