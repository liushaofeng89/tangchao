package tk.tangchao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tk.tangchao.pojo.UserInfo;
import tk.tangchao.service.LoginService;
import tk.tangchao.util.Constant;


public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public Login() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取提交的用户参数
		request.setCharacterEncoding("UTF-8");		
		response.setContentType("text/html;charset=UTF-8");
		
		String userid=request.getParameter("id").trim();
		String pwd=request.getParameter("pwd").trim();
		String role=request.getParameter("role").trim();
		String identifiedCode=request.getParameter("yzm").trim();
		
		HttpSession session=request.getSession();
		
		PrintWriter out=response.getWriter();
		if(identifiedCode.equals(session.getAttribute("numrand"))){//如果验证码输入正确则进入登陆验证
			
			LoginService ls=new LoginService();
			
			UserInfo ui=ls.login(userid,pwd,role);
			
			if(ui.getUserId()!=null)
			{
				session.setAttribute("lsf_tc_userinfo", ui);  
				
				//设置session过期时间
				session.setMaxInactiveInterval(Constant.VALIDITY_SESSION_TIME);
				
				//跳转到收银员管理页面
				if("收银员".equals(role)){  

					out.write("c"); 
					
				}else if("老板".equals(role)){  //跳转到老板管理页面
					
					out.write("b");  
					
				}else if("员工".equals(role)){  //跳转到普通员工管理页面
					
					out.write("e");
					
				}else{//系统故障
					out.write("error");
				}
				
			}else{  //登陆信息验证未通过，停留在登陆页面(返回"1")
				
				out.write("1");
				
			}
			
		}else{ //验证码验证未通过，停留在登陆页面(返回"0")
			
			out.write("0"); 
		}
		
	}

	public void init() throws ServletException {
	}

}
