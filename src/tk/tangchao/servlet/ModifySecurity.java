package tk.tangchao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tk.tangchao.pojo.UserInfo;
import tk.tangchao.service.SecurityService;

public class ModifySecurity extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ModifySecurity() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}
	
	
	/**
	 * doGet方法用于处理系统密码修改部分的密码修改：
	 * 1、用于boss登录的时候验证boss账户的原密码是否正确
	 * 2、用于验证修改employee和cashier的员工工号是否有效
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw=response.getWriter();
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String type=request.getParameter("type");
		
		if(id==""){//检测原密码是否正确
			
			UserInfo u=(UserInfo)session.getAttribute("lsf_tc_userinfo");
			
			id=u.getUserId();//获取当前会话的id
			
			SecurityService ss=new SecurityService();
			
			String sc=ss.doCheck(id+"admin", pwd, type);

			pw.write(sc);
			
		}else{//检测该用户是否存在且在职
			
			SecurityService ss=new SecurityService();
			
			String sc=ss.doCheck(id, pwd, type);

			pw.write(sc);
			
		}

	}
	
	
	
	
	
	
	/**
	 * 
	 * doPost方法用于处理系统密码修改部分的密码修改：
	 * 完成密码修改的所有步骤
	 * 
	 */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id=request.getParameter("id");
		
		String pwd=request.getParameter("pwd");
		
		String type=request.getParameter("type");
		
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session=request.getSession();
		
		PrintWriter pw=response.getWriter();
		
		if(id==""){
			
			UserInfo u=(UserInfo)session.getAttribute("lsf_tc_userinfo");
			
			id=u.getUserId();//获取当前会话的id
		}
		
		SecurityService ss=new SecurityService();
		
		String sc=ss.doCheck(id, pwd, type);

		pw.write(sc);

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
