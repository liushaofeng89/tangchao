package tk.shaofeng.tangchao.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tk.shaofeng.tangchao.hbn.AbstractTCDAO;
import tk.shaofeng.tangchao.model.ServiceModel;

public class ServiceInfoDAO extends AbstractTCDAO
{

	/**
	 * save a vip user to db
	 * 
	 * @param user the user which need to register
	 */
	public boolean save(ServiceModel model)
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
	 * load all service info
	 * 
	 * @return service model list
	 */
	@SuppressWarnings("unchecked")
	public List<ServiceModel> findAll()
	{
		String hql = "from ServiceModel model where model.enabled = true";
		Session session = getSession();
		Query createQuery = session.createQuery(hql);
		List<ServiceModel> list = (List<ServiceModel>) createQuery.list();
		session.close();
		return list;
	}
}
