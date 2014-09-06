package tk.tangchao.service;

import java.sql.SQLException;

import sun.jdbc.rowset.CachedRowSet;
import tk.tangchao.pojo.UserInfo;
import tk.tangchao.util.DBConn;
import tk.tangchao.util.MD5;

import java.text.SimpleDateFormat;
import java.util.Date;


public class LoginService {
	
	@SuppressWarnings("unused")
	private static boolean flag=false;  //设置用户信息验证是正确标志 
	
	public LoginService(){}
	
	public UserInfo login(String userid,String pwd,String role){
		
		CachedRowSet crs;
		
		UserInfo ui=new UserInfo();
		
		String sql="select count(*) from user_info where user_id='"+userid+"' AND user_leavetime ='' or user_leavetime is null";
		
		DBConn.getConnection();
		
		CachedRowSet rs=DBConn.query(sql);
		
		try {
			
			rs.next();
			
			int n=rs.getInt(1);
			
			//如果该员工工号存在且还在正常工作
			if(n!=0){
				
				DBConn.getConnection();
				
				sql="select * from user_info where user_id='"+userid+"'";

				crs=DBConn.query(sql);
				
				crs.next();
				
				//如果密码和登录角色匹配
				if(MD5.md5s(pwd).equals(crs.getString("user_pwd"))&&role.equals(crs.getString("user_role"))){
					
					ui.setUserId(crs.getString("user_id"));
					
					ui.setUserName(crs.getString("user_name"));
					
					ui.setUserSex(crs.getString("user_sex"));
					
					ui.setUserRole(crs.getString("user_role"));
					
					ui.setUserType(crs.getString("user_type"));
					
					ui.setUserJoinTime(crs.getString("user_jointime"));
					
					ui.setUserLeavTime(crs.getString("user_leavetime"));
					
					ui.setUserMail(crs.getString("user_mail"));
					
					ui.setUserLastTime(crs.getString("user_lasttime"));
					
					//更新登陆本次登陆的时间
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					String lastTime=df.format(new Date());// new Date()为获取当前系统时间
					
					DBConn.getConnection();
					
					sql="update user_info set user_lasttime='"+lastTime+"' where user_id='"+userid+"'";

					DBConn.update(sql);
					
					flag = true;
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ui;
		
	}
	
	
}
