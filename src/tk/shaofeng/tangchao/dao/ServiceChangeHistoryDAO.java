package tk.shaofeng.tangchao.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tk.shaofeng.tangchao.hbn.AbstractTCDAO;
import tk.shaofeng.tangchao.model.ServiceChangeHistoryModel;

/**
 * 服务价格维护数据库操作层
 * 
 * @author liushaofeng
 * @date 2014-9-27
 */
public class ServiceChangeHistoryDAO extends AbstractTCDAO
{
	/**
	 * 添加一条记录
	 * 
	 * @param model 需要添加的数据模型
	 * @return 添加是否成功
	 */
	public boolean save(ServiceChangeHistoryModel model)
	{
		Transaction tx = null;
		Session session = getSession();
		try
		{
			tx = session.beginTransaction();
			session.save(model);
			tx.commit();
			session.close();
			return true;
		}
		catch (Exception e)
		{
			Logger.getLogger(this.getClass()).error(e.getMessage(), e);
			tx.rollback();
			session.close();
			return false;
		}
	}

	/**
	 * 获取所有历史修改记录
	 * 
	 * @return 历史修改记录数据集合
	 */
	@SuppressWarnings("unchecked")
	public List<ServiceChangeHistoryModel> findAll()
	{
		Session session = getSession();
		String priceHql = "from ServiceChangeHistoryModel model order by model.serviceId,model.lastModifyTime desc";
		Query priceQuery = session.createQuery(priceHql);
		List<ServiceChangeHistoryModel> priceList = (List<ServiceChangeHistoryModel>) priceQuery.list();
		session.close();
		return priceList;
	}
}
