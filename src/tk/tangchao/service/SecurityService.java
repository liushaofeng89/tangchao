package tk.tangchao.service;

import java.sql.SQLException;

import sun.jdbc.rowset.CachedRowSet;
import tk.tangchao.util.DBConn;
import tk.tangchao.util.MD5;

public class SecurityService {
	
	public SecurityService(){}
	
	String r="";
	
	
	/**
	 * 用于密码验证、工号查询以及密码修改功能
	 * 1、检查密码正确、工号合法(type为'c')
	 * 2、修改密码(type为'u')
	 */
	public String doCheck(String id,String pwd,String type){
		
		DBConn.getConnection();
		
		if("c".equals(type)){  //检测密码和工号部分
			
			if(id.contains("admin")){  //检测原密码是否正确
				
				String sql="select count(*) from user_info where user_id='"+id.substring(0, id.lastIndexOf("admin"))+"' AND user_pwd ='"+MD5.md5s(pwd)+"'";
				DBConn.getConnection();
				CachedRowSet rs=DBConn.query(sql);
				try {
					rs.next();
					int n=rs.getInt(1);
					if(n!=0){
						
						r="1";  //表示原密码正确
						
					}else{
						
						r="0";  //表示原密码不正确
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}	
					
			}else{//检测当前账户是否合法
				
				String sql="select count(*) from user_info where user_id='"+id+"' AND user_leavetime =''";

				CachedRowSet rs=DBConn.query(sql);
				
				try {
					rs.next();
					
					int n=rs.getInt(1);

					if(n!=0){
						
						r="2";  //表示该工号存在且在职
						
					}else{
						
						r="3";  //表示该工号不存在或离职
						
						}
					}catch (SQLException e) {
						e.printStackTrace();
					}
				
			}
		
			
			
			
		}else{  //修改密码部分
			
			String sql="update user_info set user_pwd='"+MD5.md5s(pwd)+"' where user_id='"+id+"'";
			
			boolean b=DBConn.update(sql);
			
			if(true==b){//密码修改成功
				
				r="success";
				
			}else{
				
				r="fail";
				
			}
		}
		
		return r;
		
	}
}
