package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TDao2 {
	
	private static String username ="scott";
	private static String password ="tiger";
	private static String urldefault="jdbc:default:connection:";
	private static String urlthin="jdbc:oracle:thin:@192.168.177.201:1521:orcl";
	private static String urloci ="jdbc:oracle:oci:@orcl_201";
	private static String driver="oracle.jdbc.driver.OracleDriver";
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(urldefault, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void add(int id,String name) throws SQLException{
		Connection conn = getConnection();
		
		String sql = "insert into t values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	
	public static void main(String[] args) throws SQLException {
		add(3,"wangwu");
	}
}
