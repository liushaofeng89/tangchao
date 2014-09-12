package tk.shaofeng.tangchao.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.shaofeng.tangchao.dao.RechargeDAO;
import tk.shaofeng.tangchao.dao.UserQueryDAO;
import tk.shaofeng.tangchao.model.RechargeModel;
import tk.shaofeng.tangchao.model.UserModel;
import tk.shaofeng.tangchao.util.TCConstant;

import com.google.gson.Gson;

/**
 * Load User Infomation
 * 
 * @author liushaofeng
 * @date 2014-8-23
 */
public class QueryUserService extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6504802322528078007L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType(TCConstant.JSON_TYPE_ENCODING);

		String queryType = req.getParameter("type");
		// 获取用户信息
		UserQueryDAO dao = new UserQueryDAO();
		List<UserModel> userList = null;
		PrintWriter writer = resp.getWriter();

		if (Boolean.parseBoolean(queryType))
		{
			userList = dao.findUserByCardId(req.getParameter("cardId"));
		}
		else
		{
			userList = dao.findAllUserByTimeSort("desc");
		}
		// 获取用户的余额信息
		RechargeDAO rechargeDAO = new RechargeDAO();
		for (UserModel userModel : userList)
		{
			List<RechargeModel> findByCardIdDesc = rechargeDAO.findByCardIdDesc(userModel.getCardId());
			if (findByCardIdDesc.isEmpty())
			{
				continue;
			}
			else
			{
				RechargeModel rechargeModel = findByCardIdDesc.get(0);
				userModel.setRemain(rechargeModel.getRemain());
			}
		}
		writer.write(new Gson().toJson(userList));
	}
}
