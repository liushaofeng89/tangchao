package tk.shaofeng.tangchao.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tk.shaofeng.tangchao.dao.LoginDAO;
import tk.shaofeng.tangchao.util.TCConstant;

/**
 * Servlet for user login
 */
public class LoginService extends HttpServlet
{
	public static final String USER_NAME = "USER_NAME";
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	/**
	 * Default constructor.
	 */
	public LoginService()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		PrintWriter writer = response.getWriter();
		if (new LoginDAO().verify(userName, pwd))
		{
			session = request.getSession();
			session.setAttribute(USER_NAME, userName);
			session.setMaxInactiveInterval(TCConstant.SESSION_TIME_OUT);

			writer.write("SUCCESS");
		}
		else
		{
			writer.write("FAIL");
		}
	}
}
