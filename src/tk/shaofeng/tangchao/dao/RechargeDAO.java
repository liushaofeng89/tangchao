package tk.shaofeng.tangchao.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tk.shaofeng.tangchao.hbn.AbstractTCDAO;
import tk.shaofeng.tangchao.model.RechargeModel;

/**
 * User recharge DB access
 * 
 * @author liushaofeng
 * @date 2014-8-31
 */
public class RechargeDAO extends AbstractTCDAO
{
	/**
	 * recharge value to user by user card ID
	 * 
	 * @param cardId user card ID
	 * @param value recharge amount
	 * @return recharge success or not
	 */
	public boolean updateById(int cardId, int value)
	{
		return false;
	}

	/**
	 * add one record to DB
	 * 
	 * @param model one record need to add
	 * @return add success or not
	 */
	public boolean save(RechargeModel model)
	{
		Session session = getSession();
		Transaction tx = null;
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
	 * find by card ID and recharge time desc
	 * 
	 * @param cardId card ID
	 * @return recharge records
	 */
	@SuppressWarnings("unchecked")
	public List<RechargeModel> findByCardIdDesc(int cardId)
	{
		String hql = "from RechargeModel model where model.cardId = ? order by model.rechageDate desc";
		Session session = getSession();
		Query createQuery = session.createQuery(hql);
		createQuery.setParameter(0, cardId);
		List list = createQuery.list();
		session.close();
		return list;
	}
}
