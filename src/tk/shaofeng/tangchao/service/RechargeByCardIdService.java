package tk.shaofeng.tangchao.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.shaofeng.tangchao.dao.RechargeDAO;
import tk.shaofeng.tangchao.model.RechargeModel;
import tk.shaofeng.tangchao.util.TCConstant;

/**
 * 通过卡号给用户充值
 * 
 * @author liushaofeng
 * @date 2014-8-31
 */
public class RechargeByCardIdService extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4767660719711068287L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setCharacterEncoding(TCConstant.ENCODING);
		long cardId = -1;
		int rechargeVal = -1;
		PrintWriter writer = resp.getWriter();
		try
		{
			cardId = Long.parseLong(req.getParameter("cardId"));
			rechargeVal = Integer.parseInt(req.getParameter("rechargeVal"));
		}
		catch (NumberFormatException e)
		{
			writer.write("会员卡号或充值金额错误！");
		}

		RechargeDAO rechargeDAO = new RechargeDAO();
		double remain = getRemain(rechargeDAO, cardId, rechargeVal);
		RechargeModel model = new RechargeModel(cardId, rechargeVal, remain, new Date());
		rechargeDAO.save(model);

		writer.write("卡号:" + cardId + "          \r充值金额：" + rechargeVal + ",          \r账户余额为：" + remain);
	}

	/**
	 * compute the user remain
	 * 
	 * @param rechargeDAO recharge DAO
	 * @param cardId card ID
	 * @param rechargeVal recharge amount
	 * @return remain after rechaged
	 */
	private double getRemain(RechargeDAO rechargeDAO, long cardId, int rechargeVal)
	{
		List<RechargeModel> recordList = rechargeDAO.findByCardIdDesc(cardId);
		if (!recordList.isEmpty())
		{
			RechargeModel rechargeModel = recordList.get(0);
			return rechargeVal + rechargeModel.getRemain();
		}
		else
		{
			return 0.0;
		}
	}
}
