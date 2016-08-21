package day2.pool;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.LinkedList;
import java.util.Map;
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
 * ****************数据库连接池*****************
 * 
 * @author shuang
 * @version 1.0 Oct 28, 2011
 */
public class DbUtils {
	/**
	 * 此类的作用是维护多个连接
	 */
	private static LinkedList<Connection> conns = new LinkedList<Connection>();
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
			String poolsize = p.getProperty("poolsize");			
			
			
			Class.forName(driver);								//5:开始与数据库建连接	
			
			for(int i=0;i<Integer.parseInt(poolsize);i++){
				Connection con=DriverManager.getConnection(url, name, pwd);
				con = new MyConnection(con) ;
				conns.add(con);
	//			System.out.println(con);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 书写静态方法返回Connection的实例
	 */
	public static Connection getConn(){
		System.err.println("还有："+conns.size());
		return conns.removeFirst();
	}
	
	@Test
	//测试
	public void testconnection() throws Exception{	
//		DbUtils dd;		
//		Connection con = DbUtils.getConn();
//		System.out.println(con);
	}
	
	/*
	 * 声明成内部且私有，不希望被其他类发现
	 */
	private static class MyConnection implements Connection{
		/*
		 * 声明一个Connection的连接对像
		 */
		private Connection conn;
		/*
		 * 在构造方法接收此对像的实例
		 */
		public MyConnection(Connection co){
			this.conn=co;
		}
		
		public void clearWarnings() throws SQLException {
			conn.clearWarnings();
		}
		public void close() throws SQLException {
			conns.addLast(this);
		}
		public void commit() throws SQLException {
			conn.commit();
		}
		public Array createArrayOf(String typeName, Object[] elements)
				throws SQLException {
			return conn.createArrayOf(typeName, elements);
		}
		public Blob createBlob() throws SQLException {
			return conn.createBlob();
		}

		public Clob createClob() throws SQLException {
			return conn.createClob();
		}

		public NClob createNClob() throws SQLException {
			return conn.createNClob();
		}

		public SQLXML createSQLXML() throws SQLException {
			return conn.createSQLXML();
		}

		public Statement createStatement() throws SQLException {
			return conn.createStatement();
		}

		public Statement createStatement(int resultSetType,
				int resultSetConcurrency) throws SQLException {
			return conn.createStatement(resultSetType,resultSetConcurrency);
		}

		public Statement createStatement(int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			return conn.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
		}

		public Struct createStruct(String typeName, Object[] attributes)
				throws SQLException {
			return conn.createStruct(typeName, attributes);
		}

		public boolean getAutoCommit() throws SQLException {
			return conn.getAutoCommit();
		}

		public String getCatalog() throws SQLException {
			return conn.getCatalog();
		}

		public Properties getClientInfo() throws SQLException {
			return conn.getClientInfo();
		}

		public String getClientInfo(String name) throws SQLException {
			return conn.getClientInfo(name);
		}

		public int getHoldability() throws SQLException {
			return conn.getHoldability();
		}

		public DatabaseMetaData getMetaData() throws SQLException {
			return conn.getMetaData();
		}

		public int getTransactionIsolation() throws SQLException {
			return conn.getTransactionIsolation();
		}

		public Map<String, Class<?>> getTypeMap() throws SQLException {
			return conn.getTypeMap();
		}

		public SQLWarning getWarnings() throws SQLException {
			return conn.getWarnings();
		}

		public boolean isClosed() throws SQLException {
			return false;
		}

		public boolean isReadOnly() throws SQLException {
			return conn.isReadOnly();
		}

		public boolean isValid(int timeout) throws SQLException {
			return conn.isValid(timeout);
		}

		public String nativeSQL(String sql) throws SQLException {
			return conn.nativeSQL(sql);
		}

		public CallableStatement prepareCall(String sql) throws SQLException {
			return conn.prepareCall(sql);
		}

		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency) throws SQLException {
			return conn.prepareCall(sql, resultSetType, resultSetConcurrency);
		}

		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			return conn.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
		}

		public PreparedStatement prepareStatement(String sql)
				throws SQLException {
			return conn.prepareStatement(sql);
		}

		public PreparedStatement prepareStatement(String sql,
				int autoGeneratedKeys) throws SQLException {
			return conn.prepareStatement(sql, autoGeneratedKeys);
		}

		public PreparedStatement prepareStatement(String sql,
				int[] columnIndexes) throws SQLException {
			return conn.prepareStatement(sql, columnIndexes);
		}

		public PreparedStatement prepareStatement(String sql,
				String[] columnNames) throws SQLException {
			return conn.prepareStatement(sql, columnNames);
		}

		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency)
				throws SQLException {
			return conn.prepareStatement(sql, resultSetType, resultSetConcurrency);
		}

		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			return conn.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
		}

		public void releaseSavepoint(Savepoint savepoint) throws SQLException {
			conn.releaseSavepoint(savepoint);
		}

		public void rollback() throws SQLException {
			conn.rollback();
		}

		public void rollback(Savepoint savepoint) throws SQLException {
			conn.rollback(savepoint);
		}

		public void setAutoCommit(boolean autoCommit) throws SQLException {
			conn.setAutoCommit(autoCommit);
		}

		public void setCatalog(String catalog) throws SQLException {
			conn.setCatalog(catalog);
		}

		public void setClientInfo(Properties properties)
				throws SQLClientInfoException {
			conn.setClientInfo(properties);
		}

		public void setClientInfo(String name, String value)
				throws SQLClientInfoException {
			conn.setClientInfo(name, value);
		}

		public void setHoldability(int holdability) throws SQLException {
			conn.setHoldability(holdability);
		}

		public void setReadOnly(boolean readOnly) throws SQLException {
			conn.setReadOnly(readOnly);
		}

		public Savepoint setSavepoint() throws SQLException {
			return conn.setSavepoint();
		}

		public Savepoint setSavepoint(String name) throws SQLException {
			return conn.setSavepoint(name);
		}

		public void setTransactionIsolation(int level) throws SQLException {
			conn.setTransactionIsolation(level);
		}

		public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
			conn.setTypeMap(map);
		}

		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			return conn.isWrapperFor(iface);
		}

		public <T> T unwrap(Class<T> iface) throws SQLException {
			return conn.unwrap(iface);
		}
	}
	
}
