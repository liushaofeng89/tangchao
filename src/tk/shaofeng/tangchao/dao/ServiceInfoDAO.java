package tk.shaofeng.tangchao.dao;

import java.util.List;

import org.hibernate.Query;

import tk.shaofeng.tangchao.hbn.AbstractTCDAO;
import tk.shaofeng.tangchao.model.ServiceModel;

public class ServiceInfoDAO extends AbstractTCDAO
{
	/**
	 * load all service info
	 * 
	 * @return service model list
	 */
	@SuppressWarnings("unchecked")
	public List<ServiceModel> findAll()
	{
		String hql = "from ServiceModel";
		Query createQuery = getSession().createQuery(hql);
		return (List<ServiceModel>) createQuery.list();
	}
}
