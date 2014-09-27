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
	 * find by ID
	 * 
	 * @return service model
	 */
	@SuppressWarnings("unchecked")
	public ServiceModel findById(int id)
	{
		String hql = "from ServiceModel model where model.id = ?";
		Session session = getSession();
		Query createQuery = session.createQuery(hql);
		createQuery.setParameter(0, id);
		List<ServiceModel> list = (List<ServiceModel>) createQuery.list();
		session.close();
		if (list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	/**
	 * find by service name
	 * 
	 * @param nameStr service name
	 * @return the service model
	 */
	@SuppressWarnings("unchecked")
	public ServiceModel findByName(String nameStr)
	{
		String hql = "from ServiceModel model where model.name = ?";
		Session session = getSession();
		Query createQuery = session.createQuery(hql);
		createQuery.setParameter(0, nameStr);
		List<ServiceModel> list = (List<ServiceModel>) createQuery.list();
		session.close();
		if (list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
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

	/**
	 * disabled model by id
	 * 
	 * @param id data model id
	 * @return disabled success or not
	 */
	public boolean delete(int id)
	{
		ServiceModel model = findById(id);
		model.setEnabled(false);

		Transaction tx = null;
		Session session = getSession();
		try
		{
			tx = session.beginTransaction();
			session.saveOrUpdate(model);
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

}
