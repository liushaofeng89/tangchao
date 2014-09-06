package tk.tangchao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sun.jdbc.rowset.CachedRowSet;
import tk.tangchao.pojo.JsonUserInfo;
import tk.tangchao.pojo.RoleInfo;
import tk.tangchao.pojo.UserInfo;
import tk.tangchao.util.DBConn;
import tk.tangchao.util.MD5;

import com.google.gson.Gson;
/**
 * <生成各种json数据类>
 * @author liushaofeng
 * @version version 1.0.0
 * @since
 */
public class JsonService {
	
	//区分json类型的变量
	private static String TYPE=null;
	
	//员工信息分页参数和每页的行数
	private int PAGE;
	private int ROWS;
	
	
	/**
	 * 构造方法，初始化变量
	 * @param type ：根据type的不同来生成对应的json
	 * @param a :分页是的第几页
	 * @param b ：分页时的每页的行数
	 */
	public JsonService(String type,int a,int b) {
		this.TYPE=type;
		this.PAGE=a;
		this.ROWS=b;
		
	}
	
	
	/**
	 * <json的具体生成方法>
	 * @return 生成的json字符串
	 */
	public String generate(){
		
		Gson g=new Gson();
		
		DBConn.getConnection();
		
		CachedRowSet rs;
		
		String json="";//定义保存json数据的字符串
		
		List<Object> al =new ArrayList<Object>();
		
		//更具请求不同生成不同的json数据
		if("employee_role".equals(TYPE)){
			
			String sql="select * from role_info";
			
			try {
				
				rs=DBConn.query(sql);
				while(rs.next()){
					
					RoleInfo ri=new RoleInfo();
					
					ri.setRole_id(rs.getString("role_id"));
					
					ri.setRole_name(rs.getString("role_name"));
					
					al.add(ri);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			json=g.toJson(al);
			
		}else if("userinfo".equals(TYPE)){//获取系统所有在职员工的信息
			
			JsonUserInfo jui=new JsonUserInfo();
			
			String sql="select count(*) from user_info where user_leavetime='' or user_leavetime is null";
			
			try {
				rs=DBConn.query(sql);
				rs.next();
				jui.setTotal(rs.getInt(1));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				DBConn.getConnection();
				
				sql="select * from user_info where user_leavetime is null or user_leavetime='' limit "+(PAGE-1)*ROWS+","+ROWS;
				
				rs=DBConn.query(sql);
				
				while(rs.next()){
					
					UserInfo u=new UserInfo();
					u.setUserId(rs.getString("user_id"));
					u.setUserName(rs.getString("user_name"));
					u.setUserSex(rs.getString("user_sex"));
					u.setUserRole(rs.getString("user_role"));
					u.setUserType(rs.getString("user_type"));
					u.setUserMail(rs.getString("user_mail"));
					u.setUserJoinTime(rs.getString("user_jointime"));
					u.setUserLastTime(rs.getString("user_lasttime"));
					al.add(u);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			jui.setRows(al);
			json=g.toJson(jui);	
			
		}else if("employee".equals(TYPE)){//获取系统所有在职员工的信息
			
			JsonUserInfo jui=new JsonUserInfo();
			
			String sql="select count(*) from user_info where user_leavetime='' or user_leavetime is null";
			
			try {
				rs=DBConn.query(sql);
				rs.next();
				jui.setTotal(rs.getInt(1));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				DBConn.getConnection();
				
				sql="select * from user_info where user_leavetime is null or user_leavetime='' limit "+(PAGE-1)*ROWS+","+ROWS;
				
				rs=DBConn.query(sql);
				
				while(rs.next())
				{
					UserInfo u=new UserInfo();
					u.setUserId(rs.getString("user_id"));
					u.setUserName(rs.getString("user_name"));
					u.setUserSex(rs.getString("user_sex"));
					u.setUserRole(rs.getString("user_role"));
					u.setUserType(rs.getString("user_type"));
					u.setUserMail(rs.getString("user_mail"));
					u.setUserJoinTime(rs.getString("user_jointime"));
					u.setUserLastTime(rs.getString("user_lasttime"));
					al.add(u);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			jui.setRows(al);
			json=g.toJson(jui);	
			
		}
		
		return json;
	}

	
	
	
	
}
