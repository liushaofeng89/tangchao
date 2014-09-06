package tk.tangchao.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;


import sun.jdbc.rowset.CachedRowSet;

public class DBConn {
	public static Logger logger = Logger.getLogger(DBConn.class);
	public static Connection conn=null;
	private static String url,user,password;
	static{
		Properties p=new Properties();
		InputStream is=DBConn.class.getResourceAsStream("connDB.properties");
		try {
			p.load(is);
		} catch (IOException e) {
			logger.error("数据库配置文件读取失败！");
		}
		
		url=p.getProperty("url");
		user=p.getProperty("username");
		password=p.getProperty("password");
	}
	
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			logger.error("数据库连接失败:"+e.toString());
		}
		return conn;
	}
	
	
	public static CachedRowSet query(String sql)
	{
		
		//CachedRowSet extends sun.jdbc.rowset.BaseRowSet implements javax.sql.RowSet, javax.sql.RowSetInternal, java.io.Serializable, java.lang.Cloneable
		CachedRowSet crs=null;
		ResultSet rs=null;
		try {
			crs=new CachedRowSet();
			Statement stmt=conn.createStatement();
			rs= stmt.executeQuery(sql);
			crs.populate(rs);
			conn.close();
		} catch (SQLException e) {
			logger.error("CachedRowSet查询失败:"+e.toString());
		}
		return crs;
	}
	
	public static ResultSet RSquery(String sql)
	{
		ResultSet rs=null;
		try {
			Statement stmt=conn.createStatement();
			rs= stmt.executeQuery(sql);
		} catch (SQLException e) {
			logger.error("ResultSet查询失败:"+e.toString());
		}
		return rs;
	}
	
	
	/**
	 * 关闭数据库连接，释放资源
	 * @return boolean
	 */
	public static boolean closeConn()
	{
		boolean flag = false;
		try {
			if(!conn.isClosed())
			{
				conn.close();
				flag = true;
			}
		} catch (SQLException e1) {
			logger.error("数据库连接关闭异常:"+e1.toString());
			flag = false;
		}
		return flag;
	}
	
	
	
	public static boolean update(String sql)
	{
		boolean f=true;
		try {
			DBConn.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			f=false;
			logger.error("更新数据失败:"+e.toString());
		}
		return f;
	}
	
	
	/*
	 * prepareStatement例子
	 * 
	public static boolean preUpdate()
	{
		boolean f=true;
		//This part is hardcode
		String sql="insert into jdbctest values(?,?,?)";
		try {
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,10);
		ps.setString(2,"lsf");
		ps.setString(3,"liu891");
		ps.executeUpdate();
		} catch (SQLException e) {
			f=false;
			e.printStackTrace();
		}
		return f;
	}*/
	

}
