package tk.tangchao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import tk.tangchao.pojo.UserInfo;

public class RightCheck implements Filter {
	
	public static Logger logger = Logger.getLogger(RightCheck.class);

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)arg0; //将请求转换为HttpServletRequest
		
		HttpServletResponse response=(HttpServletResponse)arg1;  //将请求转换为HttpServletResponse 
		
		
		//检测请求的是否为后台管理并且排除js和css等常规资源请求
		if(request.getRequestURI().contains("boss")||request.getRequestURI().contains("cashier")||request.getRequestURI().contains("employee")){
			
			HttpSession session=request.getSession();
			
			//当前的session中是否有登录角色存在
			if(session.getAttribute("lsf_tc_userinfo")==null){
				
				logger.error("未授权登陆异常……");
				response.sendRedirect("/tangchao/sys/login.html");  //session中无用户角色存在，跳转到登录页面
				
			}else{
				
				UserInfo u=(UserInfo)session.getAttribute("lsf_tc_userinfo");
				
				String role=u.getUserRole();
				
				if("老板".equals(role)){
					role="boss";
				}else if("收银员".equals(role)){
					role="cashier";
				}else if("员工".equals(role)){
					role="employee";
				}
				
				if(request.getRequestURI().contains(role)){
					
					arg2.doFilter(request, response);
					
				}else{
					
					response.sendRedirect("/tangchao/sys/login.html");  //当前用户的角色与访问路径不一致
					
				}			
				
			}
			
		}else{
			
			arg2.doFilter(request, response);
			
			
		}
		
	}
	
	public void init(FilterConfig arg0) throws ServletException {

	}

}
