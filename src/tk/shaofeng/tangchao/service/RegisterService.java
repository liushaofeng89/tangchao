package tk.shaofeng.tangchao.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import tk.shaofeng.tangchao.dao.RechargeDAO;
import tk.shaofeng.tangchao.dao.UserDAO;
import tk.shaofeng.tangchao.model.RechargeModel;
import tk.shaofeng.tangchao.model.UserModel;
import tk.shaofeng.tangchao.util.MagicNum;

/**
 * user register service
 * 
 * @author liushaofeng
 * @date 2014-8-21
 */
public class RegisterService extends HttpServlet
{
	public static final String REGISTER_FAIL = "REGISTER_FAIL";
	public static final String REGISTER_SUCCESS = "REGISTER_SUCCESS";
	/**
	 *
	 */
	private static final long serialVersionUID = -5928099152329425110L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String userName = req.getParameter("userName").trim();
		String sex = "checked".equals(req.getParameter("sex")) ? "true" : "false";
		String cardId = req.getParameter("cardId").trim();
		String discounts = req.getParameter("discounts");
		String remain = req.getParameter("remain").trim();
		String cellPhoneNo = req.getParameter("cellPhoneNo");

		PrintWriter writer = resp.getWriter();
		if (!checkCardId(cardId) || !checkDiscounts(discounts) || !checkRemain(remain) || !chePhoneNo(cellPhoneNo))
		{
			writer.write(REGISTER_FAIL);
		}
		else
		{
			int carId = Integer.parseInt(cardId);
			UserModel user = new UserModel(userName, Boolean.parseBoolean(sex), new Date(), carId, Float
					.parseFloat(discounts), cellPhoneNo);

			// 注册用户
			UserDAO userDAO = new UserDAO();
			userDAO.save(user);
			// 注册初始化金额
			int amount = Integer.parseInt(remain);
			RechargeModel model = new RechargeModel(carId, amount, amount, new Date());
			RechargeDAO rechargeDAO = new RechargeDAO();
			rechargeDAO.save(model);

			writer.write(REGISTER_SUCCESS);
		}
	}

	private boolean chePhoneNo(String cellPhoneNo)
	{
		try
		{
			Long.parseLong(cellPhoneNo);
			if (cellPhoneNo.length() == 11)
			{
				return true;
			}
			return false;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}

	private boolean checkRemain(String remain)
	{
		if (remain == null)
		{
			return false;
		}
		return true;
	}

	private boolean checkDiscounts(String discounts)
	{
		if (discounts == null)
		{
			return false;
		}
		if (discounts.equals("1.0") || discounts.equals("0.9") || discounts.equals("0.8") || discounts.equals("0.7")
				|| discounts.equals("0.6") || discounts.equals("0.5"))
		{
			return true;
		}
		return false;
	}

	private boolean checkCardId(String cardId)
	{
		if (cardId == null)
		{
			return false;
		}
		if (cardId.length() != MagicNum.INT4)
		{
			return false;
		}

		try
		{
			Long.parseLong(cardId);
			return true;
		}
		catch (Exception e)
		{
			Logger.getLogger(this.getClass()).info("注册用户，卡号包含非数字字符。");
			return false;

		}
	}
}
