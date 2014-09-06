package tk.tangchao.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tk.tangchao.pojo.UserInfo;

/**
 * 用于检查操作数据库时是否具有相应的操作权限
 * @author liushaofeng
 * @version [version 1.0.0,2013-4-25]
 *
 */
public class CheckSessionRole {
	
	/**
	 * 构造方法
	 */
	public CheckSessionRole(){
		
	}
	
	/**
	 * 检查当前的session角色
	 */
	public static String check(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		UserInfo ui = (UserInfo)session.getAttribute("lsf_tc_userinfo");
		
		return (null == ui)?"null":ui.getUserRole();
		
	}
	
}
