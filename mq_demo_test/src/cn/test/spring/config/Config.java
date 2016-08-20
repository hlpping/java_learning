package cn.test.spring.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Config {
	
	private static Logger log = Logger.getLogger(Config.class);

	/** 配置文件的路径 **/
	private static String path = "";

	private static ApplicationContext ctx = null;

	/**
	 * 程序启动即初始化加载配置文件
	 */
	static {
		init();
	}

	/**
	 * 初始化
	 */
	private static void init() {
		path = System.getProperties().getProperty("user.dir") + "\\config\\";
		initLog();
		initSpring();
	}

	/**
	 * 加载log4j
	 */
	private static void initLog() {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		try {
			InputStream logfile = new FileInputStream(new File(path + "log4j.properties"));
			p.load(logfile);
			PropertyConfigurator.configure(p);
			logfile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("log4j初始化失败");
			e.printStackTrace();
		}
		log.info("log4j初始化成功");
	}
	
	private static void initSpring() {
		// TODO Auto-generated method stub
		String[] paths = {
//				"/config/dataSourceContext.xml",
//				"/config/dataAccessContext.xml",
//				"/config/applicationContext.xml"
				};
		ctx = new FileSystemXmlApplicationContext(paths);
		log.info("spring初始化成功");
	}
	
	/**
	 * 注册退出时资源清理线程
	 */
	private static void addShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread());
	}

	public static String getConfigPath() {
		return path;
	}

	public static ApplicationContext getCtx() {
		return ctx;
	}

}
