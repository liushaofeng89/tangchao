package tk.shaofeng.tangchao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tk.shaofeng.tangchao.service.LoginService;

public class RightCheckFilter extends HttpServlet implements Filter
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7017006260571307399L;

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException,
			ServletException
	{
		HttpServletRequest servetRequest = (HttpServletRequest) arg0;
		HttpSession session = servetRequest.getSession();
		String userName = (String) session.getAttribute(LoginService.USER_NAME);
		if (session.isNew() && "Tangchao".equals(userName))
		{
			// 将控制权传递到下一个过滤器
			chain.doFilter(arg0, arg1);
		}
		else
		{
			HttpServletResponse servetResponse = (HttpServletResponse) arg1;
			servetResponse.sendRedirect("login.html");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
	}
}
