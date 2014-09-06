package tk.tangchao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import sun.jdbc.rowset.CachedRowSet;
import tk.tangchao.pojo.UserInfo;
import tk.tangchao.servlet.WebInfoManage;
import tk.tangchao.util.DBConn;
import tk.tangchao.util.MD5;
/**
 * 用于员工的添加、修改和删除
 * @author liushaofeng
 * @version [version 1.0.0,2013-4-25]
 *
 */
public class UserService {
	
	Logger logger = Logger.getLogger(WebInfoManage.class);
	
	private String userId;
	private String userName;
	private String userSex;
	private String userPassword;
	private String userRole;
	private String userType;
	private String userMail;
	private String userJoinTime;
	
	/**
	 * 构造方法
	 */
	public UserService(){
		
	}
	
	/**
	 * <构造方法>
	 * @param id
	 * @param name
	 * @param password
	 * @param sex
	 * @param role
	 * @param type
	 * @param mail
	 */
	public UserService(String id ,String name ,String password,String sex ,String role ,String type ,String mail) {
		
		this.userId=id;
		this.userName=name;
		this.userSex=sex;
		this.userType=type;
		this.userMail=mail;
		
		//对密码进行md5加密
		this.userPassword=MD5.md5s(password);
				
		//加入的时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.userJoinTime=sdf.format(new Date());
	
		//获取role
		DBConn.getConnection();
		String sql="select role_name from role_info where role_id='"+role+"'";
		CachedRowSet crs=DBConn.query(sql);
		try {
			crs.next();
			this.userRole=crs.getString("role_name");
		} catch (SQLException e) {
			logger.error("获取用户角色异常："+e.toString());
		}
	}
	
	/**
	 * 注册用户
	 * @return boolean 注册是否成功
	 */
	public boolean register() {
		
		//创建数据库的链接
		Connection conn=DBConn.getConnection();
		String sql = "insert into user_info(user_id,user_name,user_pwd,user_sex,user_type,user_role,user_mail,user_jointime) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,userId);
			ps.setString(2,userName);
			ps.setString(3,userPassword);
			ps.setString(4,userSex);
			ps.setString(5,userType);
			ps.setString(6,userRole); 
			ps.setString(7,userMail); 
			ps.setString(8,userJoinTime); 
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("注册用户异常："+e.toString());
			return false;
		}
		
		return true;
	}
	
	/**删除单个员工
	 * @param request 获取session的请求
	 * @param id 需要被删除的用户id
	 * @return String
	 */
	public String deleteSinglePerson(HttpServletRequest request, String id) {
		
		String userId = ((UserInfo)request.getSession().getAttribute("lsf_tc_userinfo")).getUserId();
		
		//老板不能删除自己
		if(userId.equals(id)){
			
			return "deleteBossFail";
			
		}else{
			//更新数据库
			SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DBConn.getConnection();
			String sql = "update user_info set user_leavetime='"+sdf.format(new Date())+"' where user_id='"+id+"'";
			System.out.println(sql);
			if(DBConn.update(sql)){
				return "success";
			}else{
				return "fail";
			}
		}
	}
	
	/**
	 * 删除多个员工
	 * @return
	 * 
	 */
	public String deleteMultiPerson(String...strings) {
		
		int x=strings.length,y=0;
		//更新数据库
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < strings.length; i++) {
			DBConn.getConnection();
			String sql = "update user_info set user_leavetime='"+sdf.format(new Date())+"' where user_id='"+strings[i]+"'";
			if(DBConn.update(sql)){
				y++;
			}
		}
		return x==y ? "success" : "fail";
	}
	
	/**
	 * 修改用户信息
	 * @return
	 */
	public boolean modifyPersonInfo() {
		return true;
	}
	
	/**
	 * 判断员工号是否注册
	 * @param id 需要被注册的员工id
	 * @return
	 */
	public boolean isRegisted(){
		boolean flag = false;
		String sql = "select count(*) from user_info where user_id='"+userId+"'";
		DBConn.getConnection();
		ResultSet rs = DBConn.RSquery(sql);
		try {
			rs.next();
			int n=rs.getInt(1);
			//判断该员工号可以被注册
			if(n==0){
				flag = true;
			}
			DBConn.closeConn();
		}catch (SQLException e) {
			logger.error("查询员工是否存在异常:"+e.toString());
		}
		return flag;
	}
	
}
