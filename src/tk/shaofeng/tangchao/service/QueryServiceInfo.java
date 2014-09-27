package tk.shaofeng.tangchao.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import tk.shaofeng.tangchao.dao.ServiceChangeHistoryDAO;
import tk.shaofeng.tangchao.dao.ServiceInfoDAO;
import tk.shaofeng.tangchao.model.ServiceChangeHistoryModel;
import tk.shaofeng.tangchao.model.ServiceModel;
import tk.shaofeng.tangchao.util.TCConstant;

import com.google.gson.Gson;

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setCharacterEncoding(TCConstant.ENCODING);

		List<ServiceModel> modelList = new ServiceInfoDAO().findAll();
		List<ServiceChangeHistoryModel> priceList = new ServiceChangeHistoryDAO().findAll();

		for (ServiceModel serviceModel : modelList)
		{
			List<ServiceChangeHistoryModel> priceDataList = new ArrayList<ServiceChangeHistoryModel>();
			for (ServiceChangeHistoryModel priceModel : priceList)
			{
				if (serviceModel.getId() == priceModel.getServiceId())
				{
					priceDataList.add(priceModel);
				}
			}
			Collections.sort(priceDataList);
			serviceModel.setPriceList(priceDataList);
		}

		resp.getWriter().write(new Gson().toJson(modelList));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter writer = resp.getWriter();
		String opTypeStr = req.getParameter("opType").trim();
		boolean result = false;

		if ("ADD".equals(opTypeStr))
		{
			String nameStr = req.getParameter("name").trim();
			String priceStr = req.getParameter("price").trim();
			// 更新服务项目
			ServiceInfoDAO serviceInfoDAO = new ServiceInfoDAO();
			boolean saveService = serviceInfoDAO.save(new ServiceModel(nameStr));
			ServiceModel model = serviceInfoDAO.findByName(nameStr);
			// 更新初始化单价
			boolean savePrice = new ServiceChangeHistoryDAO().save(new ServiceChangeHistoryModel(model.getId(), Float
					.parseFloat(priceStr)));
			result = saveService && savePrice;
		}
		else if ("DELETE".equals(opTypeStr))
		{
			String idStr = req.getParameter("id");
			result = new ServiceInfoDAO().delete(Integer.parseInt(idStr));
		}
		else if ("MODIFY".equals(opTypeStr))
		{
			String idStr = req.getParameter("id");
			String newPriceStr = req.getParameter("newPrice");
			ServiceChangeHistoryModel model = null;
			try
			{
				model = new ServiceChangeHistoryModel(Integer.parseInt(idStr), Float.parseFloat(newPriceStr));
			}
			catch (NumberFormatException e)
			{
				Logger.getLogger(this.getClass()).error(e.getMessage(), e);
				writer.write("新价格或ID获取失败！");
				return;
			}
			result = new ServiceChangeHistoryDAO().save(model);
		}
		else
		{
			//do nothing
		}
		if (result)
		{
			writer.write("SUCCESS");
		}
		else
		{
			writer.write("FAIL");
		}
	}

}
