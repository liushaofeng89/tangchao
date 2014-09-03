package tk.shaofeng.tangchao.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import tk.shaofeng.tangchao.dao.ServiceInfoDAO;
import tk.shaofeng.tangchao.model.ServiceModel;
import tk.shaofeng.tangchao.util.TCConstant;

/**
 * query service info
 * 
 * @author liushaofeng
 * @date 2014-8-31
 */
public class QueryServiceInfo extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3811881735214413200L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setCharacterEncoding(TCConstant.ENCODING);

		List<ServiceModel> findAll = new ServiceInfoDAO().findAll();
		resp.getWriter().write(new Gson().toJson(findAll));
	}
}
