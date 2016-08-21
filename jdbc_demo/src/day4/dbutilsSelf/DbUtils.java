package day4.dbutilsSelf;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day4.c3p0.C3p0Utils;
/**
 * 封装数据
 * @author shuang
 * @version 1.0 Oct 29, 2011
 */
public class DbUtils {
	/**
	 * List
	 */
	public List<Map<String,Object>> query(String sql){
		List<Map<String,Object>> list =new ArrayList<Map<String,Object>>();
		Connection con =null;
		Statement st=null;
		
		try {
			//第一步：获取Conn对像
			con=C3p0Utils.getConnection();			
			st=con.createStatement();
			//2:执行查询，返回ResultSet结果信
			ResultSet set=st.executeQuery(sql);
			ResultSetMetaData data =set.getMetaData();
			//3:分析列数
			int cols=data.getColumnCount();
			//4:开始查询数据，并直接封装
			while(set.next()){
				//每将遍历一行，应该生成一个Map
				Map<String,Object> row = new HashMap<String, Object>();
				//先声明一个列名的保存对像String
				String colName = "";
				for(int i=0;i<cols;i++){
					colName=data.getColumnName(i+1);	//获取到列名
					row.put(colName, set.getObject(i+1));
				}
				list.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 返回List<JavaBean>
	 * 注意在定义javaBean时必须使用基本数据类型,并重写toString方法.
	 */
	public <T> List<T>  query(String sql,Class<T> cls){
		Connection con = null;
		Statement st = null;
		List<T> list=new ArrayList<T>();
		try{
			con=C3p0Utils.getConnection();
			st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			while(rs.next()){
				//应该实例化cls对像
				T t=cls.newInstance();
				//组织字段的set方法 setXxx,注意首字母大写
				String colName = "";
				for(int i=0;i<cols;i++){
					colName=rsmd.getColumnName(i+1);	//获取到列名
					colName=(""+colName.charAt(0)).toUpperCase()+colName.substring(1);
					colName="set"+colName;
					//通过两次反射设置一个值 
					//getMethod 的参数类型 分别是方法的名称和参数类型
					Method m= cls.getMethod(colName, Class.forName(rsmd.getColumnClassName(i+1)));
					m.invoke(t, rs.getObject(i+1));
				}
				list.add(t);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return list;
	}
}
