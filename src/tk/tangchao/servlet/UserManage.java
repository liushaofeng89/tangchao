package tk.tangchao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import tk.tangchao.service.UserService;
import tk.tangchao.util.CheckSessionRole;
import tk.tangchao.util.Utils;

public class UserManage extends HttpServlet {

	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -6782292000698048665L;
	
	Logger logger = Logger.getLogger(WebInfoManage.class);

	/**
	 * Constructor of the object.
	 */
	public UserManage() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * 修改员工信息
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		
		String userId,userIds;
		
		userId = request.getParameter("id");
		userIds = request.getParameter("ids");
		
		//验证是否具有操作权限
		if(("null".equals(CheckSessionRole.check(request)))||!("老板".equals(CheckSessionRole.check(request))))
		{
			logger.debug("用户权限异常！");
			String IP = Utils.getIP(request);
			String MAC = Utils.getMACAddress(IP);
			logger.error("用户IP:"+IP+"("+MAC+")没有修改简介的权限！");
			out.write("deleteWithNoRight");
			return;
		}
		UserService us = new UserService();
		
		//删除单个用户
		if(null == userIds){
			
			if("老板".equals(CheckSessionRole.check(request))){
				String result = us.deleteSinglePerson(request,userId);
				out.write(result);
			}
			
		}else{
			
			if("老板".equals(CheckSessionRole.check(request))){
				
				String[] ids = userIds.split("~");				
				String result = us.deleteMultiPerson(ids);
				out.write(result);
			}
			
		}
	}

	/**
	 * 注册员工
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		//获取表单提交的数据
		String userId = request.getParameter("userid");
		String userName = request.getParameter("username");
		String userSex = request.getParameter("usersex");
		String userPassword = request.getParameter("password");
		String userRole = request.getParameter("role");
		String userType = request.getParameter("type");
		String userMail = request.getParameter("usermail");
		
		//避免空指针异常（如果没有给新用户注册邮箱）
		if(userMail.length()==0){
			userMail="";
		}
		
		//性别中英文转换
		if("male".equalsIgnoreCase(userSex)){
			userSex="男";
		}else{
			userSex="女";
		}
		
		PrintWriter out = response.getWriter();
		
		//对输入的信息进行合法性判断
		if((userId.length()>=4)&&(userName.length()>0)&&(userPassword.length()>5)&&(userType.length()>=2)){
			
			
			if("null".equals(CheckSessionRole.check(request)))
			{
				logger.debug("用户权限异常！");
				String IP = Utils.getIP(request);
				String MAC = Utils.getMACAddress(IP);
				logger.error("用户IP:"+IP+"("+MAC+")没有修改简介的权限！");
				out.write("<script type='text/javascript'>alert('用户权限不足！');window.history.back();</script>");
				return;
			}
			
			if("老板".equals(CheckSessionRole.check(request))){
				
				UserService us = new UserService(userId, userName, userPassword, userSex, userRole, userType, userMail);
				boolean canBeRegisted = us.isRegisted();
				
				//如果该员工号能够被注册
				if(canBeRegisted){
					//注册是否成功
					if(us.register()){
						out.write("<script type='text/javascript'>alert('注册成功！');window.history.back();</script>");
					}else{
						out.write("<script type='text/javascript'>alert('注册失败,请与系统管理员取得联系！');window.history.back();</script>");
					}
				}else{
					out.write("<script type='text/javascript'>alert('该员工账号已经被注册,请重新注册！');window.history.back();</script>");
				}
				
			}else{
				
				logger.debug("用户权限异常！");
				out.write("<script type='text/javascript'>alert('用户权限不足！');window.history.back();</script>");
				return;
				
			}
		
		}else{
			out.write("<script type='text/javascript'>alert('添加的数据不合法,请重新输入！');window.history.back();</script>");
		}
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
