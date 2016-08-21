package day2.goodsql;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;


public class TestBigText {

	@Test
	public void jdbc1() throws Exception{	
		//声明一个Reader来读取这个文本
		FileReader r = new FileReader("./src/day2/goodsql/TestBigText.java");
		
		String sql = "insert into ldata(txt) values(?)";
		Connection con = ConnUtils.getConn();		
		PreparedStatement p = con.prepareStatement(sql);
		p.setClob(1,r);
		
		p.executeUpdate();
		con.close();
		System.err.println("Over.....");
	}
	
	@Test
	public void jdbc2() throws Exception{	
		//读取并输出
		Connection con = ConnUtils.getConn();			
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from ldata");
		rs.next();		
		Reader r = rs.getClob("txt").getCharacterStream();
		BufferedReader br = new BufferedReader(r);
		String str = null;
		
		while((str=br.readLine())!=null){
			System.err.println(str);
		}
		con.close();		
	}
	
	@Test
	public void jdbc3() throws Exception{	
		//像数据库存图片
		InputStream in = new FileInputStream("./img/m.jpg");		
		String sql = "insert into ldata2(img) values(?)";
		Connection con = ConnUtils.getConn();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setBinaryStream(1,in);
		pst.executeUpdate();		
		con.close();
		System.err.println("Over......");
	}
	
	@Test
	public void jdbc4() throws Exception{	
		//读取blob
		Connection con = ConnUtils.getConn();		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from ldata2");
		rs.next();
		InputStream in = rs.getBinaryStream("img");
		OutputStream out = new FileOutputStream("d:/a.jpg");
		byte[] b = new byte[1024];
		int len = 0;
		while((len=in.read(b))!=-1){
			out.write(b,0,len);
		}
		out.close();
		in.close();
		con.close();
	}
}
